package spicy.tomato.service;

import com.liferay.admin.kernel.util.Omniadmin;

import org.osgi.service.component.annotations.Component;

/**
 * @author joankim
 */
@Component(
	immediate = true,
	property = {
		// TODO enter required service properties
	},
	service = Omniadmin.class
)
public class SpicyTomatoService implements Omniadmin {

	// TODO enter required service methods

}