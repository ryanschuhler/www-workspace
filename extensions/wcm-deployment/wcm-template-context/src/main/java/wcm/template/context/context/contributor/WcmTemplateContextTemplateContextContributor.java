
package wcm.template.context.context.contributor;

import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.portal.kernel.template.TemplateContextContributor;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author allenziegenfus
 */
@Component(
	immediate = true,
	property = {"type=" + TemplateContextContributor.TYPE_GLOBAL},
	service = TemplateContextContributor.class
)
public class WcmTemplateContextTemplateContextContributor
	implements TemplateContextContributor {

	@Override
	public void prepare(
		Map<String, Object> contextObjects, HttpServletRequest request) {

		contextObjects.put("osb_www_gdpr_accepted", request.getAttribute("OSB_WWW_GDPR_ACCEPTED"));

		contextObjects.put("journalArticleLocalService", _journalArticleLocalService);
	
	}
	
	@Reference 
	JournalArticleLocalService _journalArticleLocalService;

}