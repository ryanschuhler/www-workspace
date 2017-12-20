package spicy.tomato;

import import com.liferay.dynamic.data.mapping.service.DDMStructureLocalService;
import import com.liferay.dynamic.data.mapping.service.DDMTemplateLocalService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Joan H. Kim
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