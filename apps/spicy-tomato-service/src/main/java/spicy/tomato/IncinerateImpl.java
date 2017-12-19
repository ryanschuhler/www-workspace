package spicy.tomato;

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
	
}