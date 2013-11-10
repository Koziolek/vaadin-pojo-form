package pl.koziolekweb.vaadin.pojoform;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import pl.koziolekweb.vaadin.pojoform.converters.AddressConverter;
import pl.koziolekweb.vaadin.pojoform.converters.MyConverterFactory;
import pl.koziolekweb.vaadin.pojoform.model.Address;
import pl.koziolekweb.vaadin.pojoform.model.Human;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

	private VerticalLayout layout;
	private final MyConverterFactory converterFactory;
	private CustomForm humanForm;

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "pl.koziolekweb.vaadin.pojoform.AppWidgetSet")
	public static class Servlet extends VaadinServlet {
	}

	public MyVaadinUI() {
		super();
		converterFactory = new MyConverterFactory();
		converterFactory.addConverter(new AddressConverter());
	}

	@Override
	protected void init(VaadinRequest request) {
		getSession().setConverterFactory(converterFactory);
		layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		Human human = new Human();
		human.setFirstName("Jan");
		human.setAddress(new Address("Warszawa", "Banacha", 1L));

		humanForm = new CustomForm(human);
		layout.addComponent(humanForm);


		Button button = new Button("Click Me");
		button.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				    humanForm.commit();
			}
		});
		layout.addComponent(button);
	}

}
