package spicy.tomato;

import com.liferay.portal.kernel.util.StringParser;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Tuple;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import import com.liferay.dynamic.data.mapping.service.DDMStructureLocalService;
import import com.liferay.dynamic.data.mapping.service.DDMTemplateLocalService;

import org.osgi.service.component.annotations.Component;

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
	
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
			System.out.println("yowzers");
		}
		
	}

	public final static String STRUCTURE = "structure";
	public final static String TEMPLATE = "template";


	public void addTemplates(String[] templates) {
		for (String template : templates) {
			long groupId = ;
			long resourceClassNameId= ;
			File script = ;
			String templateKey = ;
			long groupId = ;
			long classNameId = PortalUtil.getClassNameId(
				DDMStructure.class.getName());
			long structureId = ;

			DDMTemplate ddmTemplate = DDMTemplateLocalService.fetchTemplate(
				long groupId, long classNameId, String templateKey);

			if (ddmTemplate != null) {
				DDMTemplateLocalService.updateTemplate(
					ddmTemplate.getUserId(), ddmTemplate.getTemplateId(),
					ddmTemplate.getClassPK(), ddmTemplate.getNameMap,
					ddmTemplate.getDescriptionMap(), ddmTemplate.getType(),
					ddmTemplate.getMode(), ddmTemplate.getLanguage(),
					script, ddmTemplate.getCacheable(),
					ddmTemplate.getSmallImage(), ddmTemplate.getSmallImageURL(),
					ddmTemplate.getSmallImageFile(), new ServiceContext())
			}
			else {
				DDMTemplateLocalService.addTemplate(
					_USER_ID, groupId, classNameId, structureId,
					resourceClassNameId, templateKey, Collections.emptyMap(),
					Collections.emptyMap(), StringPool.BLANK, StringPool.BLANK,
					StringPool.BLANK, script, Boolean.TRUE, Boolean.FALSE,
					StringPool.BLANK, null, serviceContext)
			}
		}
	}

	public void addStructures(String[] structures) {
		for (String structure : structures) {
			long groupId = ;
			long classNameId = PortalUtil.getClassNameId(
				JournalArticle.class.getName());
			String structureKey = ;
			String definition = ;
			storageType = "json";

			DDMStructure ddmStructure = DDMStructureLocalService.fetchStructure(
				groupId, classNameId,
				DDMStructureConstants.DEFAULT_PARENT_STRUCTURE_ID);

			if (ddmStructure != null) {
				DDMStructureLocalService.updateStructure(
					ddmStructure.getGroupId(),
					ddmStructure.getParentStructureId(),
					ddmStructure.getClassNameId(),
					ddmStructure.getStructureKey(), ddmStructure.getNameMap(),
					ddmStructure.getDescriptionMap(), definition,
					new ServiceContext())
			}
			else {
				DDMStructureLocalService.addStructure(
					_USER_ID, groupId,
					DDMStructureConstants.DEFAULT_PARENT_STRUCTURE_ID,
					classNameId, structureKey, Collections.emptyMap(),
					Collections.emptyMap(), null, null, storageType, -1,
					new ServiceContext())
			}
		}
	}

	private static final _USER_ID = 20156L;
}