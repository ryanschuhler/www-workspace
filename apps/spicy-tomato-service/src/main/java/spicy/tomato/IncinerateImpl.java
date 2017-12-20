package spicy.tomato;

import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.model.DDMTemplate;
import com.liferay.dynamic.data.mapping.model.DDMStructureConstants;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalService;
import com.liferay.dynamic.data.mapping.service.DDMTemplateLocalService;
import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringParser;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Tuple;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Joan H. Kim
 * @author Allen R. Ziegenfus
 */
@Component(
	immediate = true,
	service = Incinerate.class
)
public class IncinerateImpl implements Incinerate {

	@Override
	public void sayHello() {
		System.out.println("Hello World!");
	}
	
	protected Map<String,String> getResourceInfo(String type, URL path) throws IOException {
		
		InputStream inputStream = new BufferedInputStream(path.openStream());

		String content = StringUtil.read(inputStream);

		StringParser stringParser = StringParser.create(
			"{fileentry:[^/]+}//{directory:[^/]+}/{ddm:[^/]+}/{groupName:[^/]+}/{structureKey:[^/]+}/{filename:[^$]+}");

		Map<String, String> params = new HashMap<>();
		stringParser.parse(path.toString(), params);

		params.put("type",  type);
		params.put("content",  content);
		return params;
	}
	
	protected Structure getStructure(Map<String,String> params) {
		Structure structure = new Structure(
				params.get("groupName"),	params.get("structureKey"), 
				params.get("content"));
		
		return structure;
	}
	
	@Activate
	protected void activate(BundleContext bundleContext) {
		
		Bundle bundle = bundleContext.getBundle();
		
		List<Structure> structures = new ArrayList<Structure>();
		try {
			Enumeration<URL> structureURLs = bundle.findEntries("/ddm", "*.json", true);
			
			while (structureURLs.hasMoreElements()) {				
				URL structureURL = structureURLs.nextElement();  
				Map<String,String> structureParams = getResourceInfo(STRUCTURE, structureURL);
				structures.add(getStructure(structureParams));
			}
			
			Map<Tuple, Structure> groupedStructures = structures.stream()
							  .collect(Collectors.toMap(structure -> new Tuple(structure.getGroupName(), structure.getStructureKey()), structure -> structure));
					
			Enumeration<URL> templateURLs = bundle.findEntries("/ddm", "*.ftl", true);
			
			while (templateURLs.hasMoreElements()) {
				URL templateURL = templateURLs.nextElement();
			    Map<String,String> templateParams = getResourceInfo(TEMPLATE, templateURL);
			    Tuple tuple = new Tuple(templateParams.get("groupName"), templateParams.get("structureKey"));
			    Structure templateStructures = groupedStructures.get(tuple);
			    
			    //TODO throw exception if no match?
			    if (templateStructures != null) {
			    		templateStructures.addTemplate(new Template(templateParams.get("filename"), templateParams.get("content")));
			    }
			}
			
			for (Structure structure : structures) {
				System.out.println(structure.getStructureKey());
				for (Template template : structure.getTemplates()) {
					System.out.println("-----" + template.getTemplateName());
				}
			}
			addStructures(structures);
	
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
			System.out.println("yowzers");
		}
		
	}

	public final static String STRUCTURE = "structure";
	public final static String TEMPLATE = "template";


	public void addTemplates(Structure structure, DDMStructure ddmStructure) throws PortalException {
		for (Template template : structure.getTemplates()) {
			long groupId = getGroupId(structure.getGroupName());
			
			long resourceClassNameId= 0;//TODO
			String script = template.getContent();
			String templateKey = template.getTemplateName();
			long classNameId = PortalUtil.getClassNameId(
				DDMStructure.class.getName());
			long structureId = ddmStructure.getStructureId() ;

			DDMTemplate ddmTemplate = _ddmTemplateLocalService.fetchTemplate(
				 groupId,  classNameId, templateKey);

			if (ddmTemplate != null) {
				_ddmTemplateLocalService.updateTemplate(
					ddmTemplate.getUserId(), ddmTemplate.getTemplateId(),
					ddmTemplate.getClassPK(), ddmTemplate.getNameMap(),
					ddmTemplate.getDescriptionMap(), ddmTemplate.getType(),
					ddmTemplate.getMode(), ddmTemplate.getLanguage(),
					script, ddmTemplate.getCacheable(),
					ddmTemplate.getSmallImage(), ddmTemplate.getSmallImageURL(),
					null, new ServiceContext());
			}
			else {
				_ddmTemplateLocalService.addTemplate(
					_USER_ID, groupId, classNameId, structureId,
					resourceClassNameId, templateKey, Collections.emptyMap(),
					Collections.emptyMap(), StringPool.BLANK, StringPool.BLANK,
					StringPool.BLANK, script, Boolean.TRUE, Boolean.FALSE,
					StringPool.BLANK, null, new ServiceContext());
			}
		}
	}

	protected long getGroupId(String groupName) {
		
		//TODO: implement
		return 10;
	}
	public void addStructures(List<Structure> structures) throws PortalException {
		for (Structure structure : structures) {
			long groupId = getGroupId(structure.getGroupName());
			long classNameId = PortalUtil.getClassNameId(
				JournalArticle.class.getName());
			String structureKey = structure.getStructureKey();
			String definition = structure.getContent();
			String storageType = "json";

			DDMStructure ddmStructure = _ddmStructureLocalService.fetchStructure(
				groupId, classNameId, structureKey);
				

			if (ddmStructure != null) {
				_ddmStructureLocalService.updateStructure(
					ddmStructure.getGroupId(),
					ddmStructure.getParentStructureId(),
					ddmStructure.getClassNameId(),
					ddmStructure.getStructureKey(), ddmStructure.getNameMap(),
					ddmStructure.getDescriptionMap(), definition,
					new ServiceContext());
			}
			else {
				ddmStructure = _ddmStructureLocalService.addStructure(
					_USER_ID, groupId,
					DDMStructureConstants.DEFAULT_PARENT_STRUCTURE_ID,
					classNameId, structureKey, Collections.emptyMap(),
					Collections.emptyMap(), null, null, storageType, -1,
					new ServiceContext());
			}
			
			addTemplates(structure, ddmStructure);
		}
	}
	
	@Reference
	private DDMStructureLocalService _ddmStructureLocalService;

	@Reference
	private DDMTemplateLocalService _ddmTemplateLocalService;

	private static final long _USER_ID = 20156L;
}