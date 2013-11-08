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

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI
{

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "pl.koziolekweb.vaadin.pojoform.AppWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

	public MyVaadinUI() {
		super();
		MyConverterFactory converterFactory = new MyConverterFactory();
		converterFactory.addConverter(new AddressConverter());
		getSession().setConverterFactory(converterFactory);
	}

	@Override
    protected void init(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);
        
        Button button = new Button("Click Me");
        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                layout.addComponent(new Label("Thank you for clicking"));
            }
        });
        layout.addComponent(button);
    }

}
