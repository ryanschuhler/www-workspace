/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.osb.www.wcm.deployment.service;

import com.liferay.dynamic.data.mapping.io.DDMFormJSONDeserializer;
import com.liferay.dynamic.data.mapping.io.DDMFormJSONSerializer;
import com.liferay.dynamic.data.mapping.model.DDMForm;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.model.DDMStructureConstants;
import com.liferay.dynamic.data.mapping.model.DDMTemplate;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalService;
import com.liferay.dynamic.data.mapping.service.DDMTemplateLocalService;
import com.liferay.dynamic.data.mapping.util.DDMUtil;
import com.liferay.journal.model.JournalArticle;
import com.liferay.osb.www.wcm.deployment.api.Structure;
import com.liferay.osb.www.wcm.deployment.api.Template;
import com.liferay.osb.www.wcm.deployment.api.WCMDeployment;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringParser;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Tuple;
import com.liferay.portal.kernel.util.Validator;

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
@Component(
	configurationPid = "com.liferay.osb.www.wcm.deployment.service.WCMDeploymentConfiguration",
	immediate = true, service = WCMDeployment.class
)
public class WCMDeploymentImpl implements WCMDeployment {

	//TODO: check first if template / structure needs updating so we do not create extra versions..

	public static final String STRUCTURE = "structure";

	public static final String TEMPLATE = "template";

	public void addStructures(List<Structure> structures)
		throws PortalException {

		if (_log.isDebugEnabled()) {
			_log.debug(
				"Using adminUserId " + _wcmDeploymentConfiguration.adminUserId());
			_log.debug(
				"Using guestGroupId " + _wcmDeploymentConfiguration.guestGroupId());
		}

		for (Structure structure : structures) {
			try {
				long groupId = getGroupId(structure.getGroupKey());
				long classNameId = PortalUtil.getClassNameId(
					JournalArticle.class.getName());
				String structureKey = structure.getStructureKey();
				String definition = structure.getContent();
				String storageType = "json";
	
				if (Validator.isNull(definition)) {
					if (_log.isDebugEnabled()) {
						_log.debug(
							"Definition is null for structure: " + structureKey);
					}
	
					continue;
				}
	
				DDMStructure ddmStructure =
					_ddmStructureLocalService.fetchStructure(
						groupId, classNameId, structureKey);
	
				DDMForm ddmForm = _ddmFormJSONDeserializer.deserialize(definition);
	
				if (ddmStructure != null) {
					

					if (ddmForm.hashCode() != ddmStructure.getDDMForm().hashCode()) {
					
						if (_log.isDebugEnabled()) {
							_log.debug("Updating structure: " + structureKey);
						}
		
						ddmStructure = _ddmStructureLocalService.updateStructure(
							_wcmDeploymentConfiguration.adminUserId(),
							ddmStructure.getStructureId(), ddmForm,
							ddmStructure.getDDMFormLayout(), new ServiceContext());
					}
				}
				else {
					Map<Locale, String> nameMap = new HashMap<>();
	
					nameMap.put(
						LocaleUtil.getDefault(), structure.getStructureKey());
	
					if (_log.isDebugEnabled()) {
						_log.debug("Adding structure: " + structureKey);
					}
	
					ddmStructure = _ddmStructureLocalService.addStructure(
						_wcmDeploymentConfiguration.adminUserId(), groupId,
						DDMStructureConstants.DEFAULT_PARENT_STRUCTURE_ID,
						classNameId, structureKey, nameMap, Collections.emptyMap(),
						ddmForm, DDMUtil.getDefaultDDMFormLayout(ddmForm),
						storageType, DDMStructureConstants.TYPE_DEFAULT,
						new ServiceContext());
				}
	
				addTemplates(structure, ddmStructure);
			} 
			catch (PortalException pe) {
				_log.error("Error deploying structure " + structure, pe);
				continue;
			}
		}
	}

	public void addTemplates(Structure structure, DDMStructure ddmStructure)
		throws PortalException {

		for (Template template : structure.getTemplates()) {
			
			try {
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
					
					if (StringUtil.equalsIgnoreCase(ddmTemplate.getScript(), script)) {
						continue;
					}
					
					if (_log.isDebugEnabled()) {
						_log.debug("Updating template: " + templateKey);
					}
	
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
	
					if (_log.isDebugEnabled()) {
						_log.debug("Adding template: " + templateKey);
					}
	
					ddmTemplate = _ddmTemplateLocalService.addTemplate(
						_wcmDeploymentConfiguration.adminUserId(), groupId,
						classNameId, structureId, resourceClassNameId, templateKey,
						nameMap, Collections.emptyMap(), StringPool.BLANK,
						StringPool.BLANK, StringPool.BLANK, script, Boolean.TRUE,
						Boolean.FALSE, StringPool.BLANK, null,
						new ServiceContext());
				}
			}
			catch (PortalException pe) {
				_log.error("Error deploying template " + template, pe);
				continue;
			}
		}
	}

	@Override
	public void deploy(Bundle bundle) {
		
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

			Map<Tuple, Structure> groupedStructures = structures.stream().
				collect(
					Collectors.toMap(
						structure -> new Tuple(structure.getGroupKey(), structure.getStructureKey()),
						structure -> structure));

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
							FileUtil.stripExtension(templateParams.get("filename")),
							templateParams.get("content")));
				}
			}

			if (_log.isDebugEnabled()) {
				_log.debug("Found following structures and templates:");

				for (Structure structure : structures) {
					_log.debug(structure.getStructureKey());

					for (Template template : structure.getTemplates()) {
						_log.debug("-----" + template.getTemplateName());
					}
				}
			}

			addStructures(structures);
		}
		catch (Exception e) {
			_log.error("Error deploying structures", e);
		}
	}
	
	@Override
	public void dumpToFilesystem(String directory) throws PortalException {
		
		FileUtil.deltree(directory);
		_log.info("Creating directory " + directory);
		FileUtil.mkdirs(directory);
		
		List<DDMStructure> ddmStructures = 
			_ddmStructureLocalService.getDDMStructures(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		
		for (DDMStructure ddmStructure : ddmStructures) {
		
			if (!StringUtil.equalsIgnoreCase(ddmStructure.getClassName(), JournalArticle.class.getName())) {
				continue;
			}
			
			Group group = _groupLocalService.fetchGroup(ddmStructure.getGroupId());
			
			if (Validator.isNull(group)) {
				_log.error( "Could not find group for " + ddmStructure.getNameCurrentValue() + " group " + 
					ddmStructure.getGroupId());
				continue;
			}
			
			DDMForm ddmForm = ddmStructure.getDDMForm();
			
			String definition = _ddmFormJSONSerializer.serialize(ddmForm);
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject(definition);
			definition = jsonObject.toString(4);
			
			String structureFileName = FileUtil.encodeSafeFileName(
				ddmStructure.getNameCurrentValue() + ".json");
			structureFileName = structureFileName.replace(CharPool.FORWARD_SLASH, CharPool.PERIOD);
			
			try {
				_log.debug("Writing structureFile " + structureFileName);
				
				FileUtil.write(directory + StringPool.FORWARD_SLASH +
						group.getGroupKey() + StringPool.FORWARD_SLASH + 
						ddmStructure.getStructureKey() + StringPool.FORWARD_SLASH + 
						structureFileName, definition);
				
				for (DDMTemplate ddmTemplate : ddmStructure.getTemplates()) {
					String templateFileName = ddmTemplate.getTemplateKey() + ".ftl";
					FileUtil.write(directory + StringPool.FORWARD_SLASH +
							group.getGroupKey() + StringPool.FORWARD_SLASH + 
							ddmStructure.getStructureKey() + StringPool.FORWARD_SLASH + 
							templateFileName, ddmTemplate.getScript());
				}
			} 
			catch (IOException e) {
				_log.error("Error writing structure or templates for file " + structureFileName, e);
			}
		}
	}
	
	@Activate
	protected void activate(
		Map<String, Object> properties, BundleContext bundleContext) {

		_wcmDeploymentConfiguration = ConfigurableUtil.createConfigurable(
			WCMDeploymentConfiguration.class, properties);

		Bundle bundle = bundleContext.getBundle();

		if (_wcmDeploymentConfiguration.autoDeploy()) {
			deploy(bundle);
		}
	}

	protected long getGroupId(String groupKey) {
		Group group = _groupLocalService.fetchGroup(
			PortalUtil.getDefaultCompanyId(), groupKey);

		if (group == null) {
			try {
				group = _groupLocalService.getGroup(
					_wcmDeploymentConfiguration.guestGroupId());
			}
			catch (PortalException pe) {
				_log.error(pe);

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
			"{fileEntry:[^/]+}//{directory:[^/]+}/{ddm:[^/]+}/{groupKey:[^/]+}/{structureKey:[^/]+}" +
				"/{filename:[^$]+}");

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

	private static final Log _log = LogFactoryUtil.getLog(
		WCMDeploymentImpl.class);

	@Reference
	private DDMFormJSONDeserializer _ddmFormJSONDeserializer;

	@Reference
	private DDMFormJSONSerializer _ddmFormJSONSerializer;
	
	@Reference
	private DDMStructureLocalService _ddmStructureLocalService;

	@Reference
	private DDMTemplateLocalService _ddmTemplateLocalService;

	@Reference
	private GroupLocalService _groupLocalService;

	private volatile WCMDeploymentConfiguration _wcmDeploymentConfiguration;

}