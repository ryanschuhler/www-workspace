package spicy.tomato;

import com.liferay.dynamic.data.mapping.io.DDMFormJSONDeserializer;
import com.liferay.dynamic.data.mapping.model.DDMForm;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.model.DDMStructureConstants;
import com.liferay.dynamic.data.mapping.model.DDMTemplate;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalService;
import com.liferay.dynamic.data.mapping.service.DDMTemplateLocalService;
import com.liferay.dynamic.data.mapping.util.DDMUtil;
import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringParser;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Tuple;
import com.liferay.portal.kernel.util.Validator;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.net.URL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
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
 * @author Ryan Schuhler
 */
@Component(immediate = true, service = Incinerate.class)
public class IncinerateImpl implements Incinerate {

	public static final String STRUCTURE = "structure";

	public static final String TEMPLATE = "template";

	public void addStructures(List<Structure> structures)
		throws PortalException {

		for (Structure structure : structures) {
			long groupId = getGroupId(structure.getGroupKey());
			long classNameId = PortalUtil.getClassNameId(
				JournalArticle.class.getName());
			String structureKey = structure.getStructureKey();
			String definition = structure.getContent();
			String storageType = "json";

			if (Validator.isNull(definition)) {
				System.out.println(
					"Definition is null for structure: " + structureKey);

				continue;
			}

			DDMStructure ddmStructure =
				_ddmStructureLocalService.fetchStructure(
					groupId, classNameId, structureKey);

			DDMForm ddmForm = _ddmFormJSONDeserializer.deserialize(definition);

			if (ddmStructure != null) {
				ddmStructure = _ddmStructureLocalService.updateStructure(
					_ADMIN_USER_ID, ddmStructure.getStructureId(),
					ddmForm,
						ddmStructure.getDDMFormLayout(), new ServiceContext());
			}
			else {
				Map<Locale, String> nameMap = new HashMap<>();

				nameMap.put(
					LocaleUtil.getDefault(), structure.getStructureKey());

				ddmStructure = _ddmStructureLocalService.addStructure(
					_ADMIN_USER_ID, groupId,
					DDMStructureConstants.DEFAULT_PARENT_STRUCTURE_ID,
					classNameId, structureKey, nameMap, Collections.emptyMap(),
					ddmForm, DDMUtil.getDefaultDDMFormLayout(ddmForm),
					storageType, DDMStructureConstants.TYPE_DEFAULT,
					new ServiceContext());
			}

			System.out.println("structure: " + ddmStructure.getStructureId());

			addTemplates(structure, ddmStructure);
		}
	}

	public void addTemplates(Structure structure, DDMStructure ddmStructure)
		throws PortalException {

		for (Template template : structure.getTemplates()) {
			long groupId = getGroupId(structure.getGroupKey());

			String script = template.getContent();
			String templateKey = template.getTemplateName();
			long classNameId = PortalUtil.getClassNameId(
				DDMStructure.class.getName());
			long resourceClassNameId = PortalUtil.getClassNameId(
				JournalArticle.class.getName());
			long structureId = ddmStructure.getStructureId();

			DDMTemplate ddmTemplate = _ddmTemplateLocalService.fetchTemplate(
				groupId, classNameId, templateKey);

			if (ddmTemplate != null) {
				ddmTemplate = _ddmTemplateLocalService.updateTemplate(
					ddmTemplate.getUserId(), ddmTemplate.getTemplateId(),
					ddmTemplate.getClassPK(), ddmTemplate.getNameMap(),
					ddmTemplate.getDescriptionMap(), ddmTemplate.getType(),
					ddmTemplate.getMode(), ddmTemplate.getLanguage(), script,
					ddmTemplate.getCacheable(), ddmTemplate.getSmallImage(),
					ddmTemplate.getSmallImageURL(), null, new ServiceContext());
			}
			else {
				Map<Locale, String> nameMap = new HashMap<>();

				nameMap.put(
					LocaleUtil.getDefault(), template.getTemplateName());

				ddmTemplate = _ddmTemplateLocalService.addTemplate(
					_ADMIN_USER_ID, groupId, classNameId, structureId,
					resourceClassNameId, templateKey, nameMap,
					Collections.emptyMap(), StringPool.BLANK, StringPool.BLANK,
					StringPool.BLANK, script, Boolean.TRUE, Boolean.FALSE,
					StringPool.BLANK, null, new ServiceContext());
			}

			System.out.println("template: " + ddmTemplate.getTemplateId());
		}
	}

	@Activate
	protected void activate(BundleContext bundleContext) {
		Bundle bundle = bundleContext.getBundle();

		List<Structure> structures = new ArrayList<>();

		try {
			Enumeration<URL> structureURLs = bundle.findEntries(
				"/ddm", "*.json", true);

			while (structureURLs.hasMoreElements()) {
				URL structureURL = structureURLs.nextElement();

				Map<String, String> structureParams = getResourceInfo(
					STRUCTURE, structureURL);
				structures.add(getStructure(structureParams));
			}

			Map<Tuple, Structure> groupedStructures = structures.stream()
				.collect(
					Collectors.toMap(
						structure -> new Tuple(
							structure.getGroupKey(),
							structure.getStructureKey()), structure -> structure));

			Enumeration<URL> templateURLs = bundle.findEntries(
				"/ddm", "*.ftl", true);

			while (templateURLs.hasMoreElements()) {
				URL templateURL = templateURLs.nextElement();

				Map<String, String> templateParams = getResourceInfo(
					TEMPLATE, templateURL);

				Tuple tuple = new Tuple(
					templateParams.get("groupKey"),
					templateParams.get("structureKey"));

				Structure templateStructures = groupedStructures.get(tuple);

				//TODO throw exception if no match?

				if (templateStructures != null) {
						templateStructures.addTemplate(
				new Template(
					templateParams.get("filename"),
					templateParams.get("content")));
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

	protected long getGroupId(String groupKey) {
		Group group = _groupLocalService.fetchGroup(
			PortalUtil.getDefaultCompanyId(), groupKey);

		if (group == null) {
			try {
				group = _groupLocalService.getGroup(_GUEST_GROUP_ID);
			} catch (PortalException e) {
				return 0;
			}
		}

		return group.getGroupId();
	}

	protected Map<String, String> getResourceInfo(String type, URL path)
		throws IOException {

		InputStream inputStream = new BufferedInputStream(path.openStream());

		String content = StringUtil.read(inputStream);

		StringParser stringParser = StringParser.create(
			"{fileEntry:[^/]+}//{directory:[^/]+}/{ddm:[^/]+}/{groupKey:[^/]+}/{structureKey:[^/]+}/{filename:[^$]+}");

		Map<String, String> params = new HashMap<>();

		stringParser.parse(path.toString(), params);

		params.put("content", content);
		params.put("type", type);

		return params;
	}

	protected Structure getStructure(Map<String, String> params) {
		Structure structure = new Structure(
				params.get("groupKey"), params.get("structureKey"),
				params.get("content"));

		return structure;
	}

	private static final long _ADMIN_USER_ID = 20156;

	private static final long _GUEST_GROUP_ID = 20143;

	@Reference
	private DDMFormJSONDeserializer _ddmFormJSONDeserializer;

	@Reference
	private DDMStructureLocalService _ddmStructureLocalService;

	@Reference
	private DDMTemplateLocalService _ddmTemplateLocalService;

	@Reference
	private GroupLocalService _groupLocalService;

}