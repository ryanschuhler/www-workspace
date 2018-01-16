package wcm.deployment.dev;

import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.model.DDMTemplate;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalServiceUtil;
import com.liferay.dynamic.data.mapping.service.DDMTemplateLocalServiceWrapper;
import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;

import org.osgi.service.component.annotations.Component;

/**
 * @author allenziegenfus
 */
@Component(
	immediate = true,
	property = {
	},
	service = ServiceWrapper.class
)
public class WcmDeploymentDev extends DDMTemplateLocalServiceWrapper {

	public WcmDeploymentDev() {
		
		super(null);
	}
	
	@Override
	public DDMTemplate fetchTemplate(
			long groupId, long classNameId, String templateKey) {
		
		return fetchTemplate(groupId, classNameId, templateKey, true);
	}
	@Override
	public com.liferay.dynamic.data.mapping.model.DDMTemplate fetchTemplate(
		long groupId, long classNameId, java.lang.String templateKey,
		boolean includeAncestorTemplates) {
		
		try {
			return getTemplate(groupId, classNameId, templateKey, includeAncestorTemplates);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return null;
   }
	
	//07:36:51,136 ERROR [localhost-startStop-1][ServiceWrapperRegistry:77] Unable to get service bag for class wcm.deployment.dev.WcmDeploymentDev
	//liferay          | java.lang.IllegalArgumentException
	@Override
	public com.liferay.dynamic.data.mapping.model.DDMTemplate getTemplate(
		long groupId, long classNameId, java.lang.String templateKey,
		boolean includeAncestorTemplates)
		throws com.liferay.portal.kernel.exception.PortalException {
		
		DDMTemplate ddmTemplate = super.getTemplate(groupId, classNameId,
			templateKey, includeAncestorTemplates);
		
		long journalArticleClassNameId = PortalUtil.getClassNameId(
				JournalArticle.class.getName());
		
		long ddmStructureClassNameId = PortalUtil.getClassNameId(
				DDMStructure.class.getName());
		
		if (classNameId == ddmStructureClassNameId) {
			
			DDMStructure ddmStructure = 
				DDMStructureLocalServiceUtil.fetchDDMStructure(ddmTemplate.getClassPK());
			
			String groupKey = GroupLocalServiceUtil.getGroup(ddmTemplate.getGroupId()).getGroupKey();
			if (ddmStructure != null && (ddmStructure.getClassNameId() == journalArticleClassNameId)) {
				//ListStructurre_wcmDeployment.getStructures(directory)
				String fileName = "/mnt/wcm/ddm/" + groupKey + "/" + 
					ddmStructure.getStructureKey() + "/" + templateKey + ".ftl";
						
				if (FileUtil.exists(fileName)) {
					try {
						String script = FileUtil.read(fileName);
					
						ddmTemplate.setScript(script);
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}
			}		
			
		}
		
		return ddmTemplate;			
	}

}