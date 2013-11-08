package pl.koziolekweb.vaadin.pojoform;

import com.vaadin.data.Buffered;
import com.vaadin.data.Validator;
import com.vaadin.server.PaintException;
import com.vaadin.server.PaintTarget;
import com.vaadin.ui.AbstractField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import pl.koziolekweb.vaadin.pojoform.model.Address;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 08.11.13
 * Time: 19:14
 * To change this template use File | Settings | File Templates.
 */
public class AddressField extends AbstractField<Address> {

	private FormLayout root;
	private final Panel panel;
	private TextField cityField = new TextField("Miasto");
	private TextField streetField = new TextField("Ulica");
	private TextField numberField = new TextField("Numer Domu");


	public AddressField() {
		super();
		panel = new Panel();
		root = new FormLayout();
		panel.setContent(root);
	}

	@Override
	public Class<? extends Address> getType() {
		return Address.class;
	}

	public void paintContent(PaintTarget target) throws PaintException {
		panel.paintContent(target);
	}

	public String getCity() {
		return cityField.getValue();
	}

	public String getStreet() {
		return streetField.getValue();
	}

	public Long getNumber() {
		return Long.getLong(numberField.getValue());
	}

	public void setCity(String city) {
		this.cityField.setValue(city);
	}

	public void setStreet(String street) {
		this.streetField.setValue(street);
	}

	public void setNumber(Long number) {
		this.numberField.setValue(number+"");
	}
}
