package pl.koziolekweb.vaadin.pojoform;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Panel;
import pl.koziolekweb.vaadin.pojoform.converters.MyFieldFactory;
import pl.koziolekweb.vaadin.pojoform.model.Human;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 09.11.13
 * Time: 13:28
 * To change this template use File | Settings | File Templates.
 */
public class CustomForm extends CustomComponent{

	private FormLayout root = new FormLayout();
	private final BeanFieldGroup<Human> bfg;

	public CustomForm(Human human) {
		bfg = new BeanFieldGroup<Human>(Human.class);
		bfg.setFieldFactory(new MyFieldFactory());
		bfg.setItemDataSource(human);
		root.addComponent(bfg.buildAndBind("Imię", "firstName"));
		root.addComponent(bfg.buildAndBind("Nazwisko", "lastName"));
		root.addComponent(bfg.buildAndBind("Adres", "address", AddressField.class));

		setCompositionRoot(prepareCompositionRoot());
	}

	private Panel prepareCompositionRoot() {
		Panel compositionRoot = new Panel();
		compositionRoot.setContent(root);
		return compositionRoot;
	}

	public void commit() {
		try {
			bfg.commit();
		} catch (FieldGroup.CommitException e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}
		System.out.println(bfg.getItemDataSource().getBean().toString());
	}
}
