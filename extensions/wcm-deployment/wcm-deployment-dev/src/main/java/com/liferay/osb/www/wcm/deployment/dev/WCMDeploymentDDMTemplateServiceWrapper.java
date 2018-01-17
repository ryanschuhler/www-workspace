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

package com.liferay.osb.www.wcm.deployment.dev;

import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.model.DDMTemplate;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalService;
import com.liferay.dynamic.data.mapping.service.DDMTemplateLocalService;
import com.liferay.dynamic.data.mapping.service.DDMTemplateLocalServiceWrapper;
import com.liferay.journal.model.JournalArticle;
import com.liferay.osb.www.wcm.deployment.api.WCMDeployment;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.Portal;

import java.io.IOException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Allen Ziegenfus
 */
@Component(
	immediate = true,
	service = ServiceWrapper.class
)
public class WCMDeploymentDDMTemplateServiceWrapper extends DDMTemplateLocalServiceWrapper {

	public WCMDeploymentDDMTemplateServiceWrapper() {
		super(null);
	}
	
	@Override
	public DDMTemplate fetchTemplate(long groupId, long classNameId, String templateKey) {
		return fetchTemplate(groupId, classNameId, templateKey, true);
	}
	
	@Override
	public DDMTemplate fetchTemplate(
		long groupId, long classNameId, java.lang.String templateKey, boolean includeAncestorTemplates) {
		
		try {
			return getTemplate(groupId, classNameId, templateKey, includeAncestorTemplates);
		} 
		catch (PortalException e) {
			_log.error("Error overriding template for template key " + templateKey, e);
		}
		
		return null;
   }
	
	@Override
	public DDMTemplate getTemplate(
			long groupId, long classNameId, java.lang.String templateKey, boolean includeAncestorTemplates)
		throws com.liferay.portal.kernel.exception.PortalException {
		
		DDMTemplate ddmTemplate = 
			super.getTemplate(groupId, classNameId, templateKey, includeAncestorTemplates);
		
		long journalArticleClassNameId = _portal.getClassNameId(JournalArticle.class.getName());
		
		long ddmStructureClassNameId = _portal.getClassNameId(DDMStructure.class.getName());
		
		if (classNameId == ddmStructureClassNameId) {
			DDMStructure ddmStructure = 
				_ddmStructureLocalService.fetchDDMStructure(ddmTemplate.getClassPK());
			
			String groupKey = _groupLocalService.getGroup(ddmTemplate.getGroupId()).getGroupKey();

			if (ddmStructure != null && (ddmStructure.getClassNameId() == journalArticleClassNameId)) {
				String templatePath = 
					_wcmDeployment.getTemplatePath(
						"/mnt/wcm", groupKey, ddmStructure.getStructureKey(), templateKey);
						
				if (FileUtil.exists(templatePath)) {
					try {
						String script = FileUtil.read(templatePath);
					
						ddmTemplate.setScript(script);
						
						_log.debug("Replacing template script for template key " + templateKey);
					} 
					catch (IOException e) {
						_log.error("Error overriding template for template key " + templateKey, e);
					}
				}
				else {
					_log.debug(
						"No template script file found on filesystem for template key " + templateKey);
				}
			}			
		}
		
		return ddmTemplate;			
	}
	
	// Needed to prevent errors on startup
	@Reference(unbind = "-")
	protected void setDDMTemplateLocalService(DDMTemplateLocalService ddmTemplateLocalService) {
		_ddmTemplateLocalService = ddmTemplateLocalService;
	}
	
	@Reference
	private DDMStructureLocalService _ddmStructureLocalService;
	
	private DDMTemplateLocalService _ddmTemplateLocalService;
	
	@Reference
	private GroupLocalService _groupLocalService;

	private static final Log _log = LogFactoryUtil.getLog(WCMDeploymentDDMTemplateServiceWrapper.class);
	
	@Reference 
	private Portal _portal;
	
	@Reference
	private WCMDeployment _wcmDeployment;
	
}