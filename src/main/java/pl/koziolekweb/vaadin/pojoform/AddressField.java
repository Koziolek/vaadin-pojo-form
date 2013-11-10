package pl.koziolekweb.vaadin.pojoform;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.vaadin.data.Property;
import com.vaadin.ui.*;
import pl.koziolekweb.vaadin.pojoform.model.Address;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 08.11.13
 * Time: 19:14
 * To change this template use File | Settings | File Templates.
 */
public class AddressField extends CustomField<Address> {

	private final Panel panel;
	private TextField cityField = new TextField("Miasto");
	private TextField streetField = new TextField("Ulica");
	private TextField numberField = new TextField("Numer Domu");
	private Set<TextField> fields = new HashSet<TextField>();
	{
		fields.add(cityField);
		fields.add(streetField);
		fields.add(numberField);
	}


	public AddressField() {
		super();
		panel = new Panel();
		FormLayout root = new FormLayout();
		root.addComponent(cityField);
		root.addComponent(streetField);
		root.addComponent(numberField);
		panel.setContent(root);
		setImmediate(true);
	}

	@Override
	public void setImmediate(final boolean immediate) {
		super.setImmediate(immediate);
		Collections2.filter(fields, new Predicate<TextField>() {
			@Override
			public boolean apply(@Nullable TextField field) {
				 field.setImmediate(immediate);
				return true;
			}
		});
	}

	@Override
	protected Component initContent() {
		return panel;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Property getPropertyDataSource() {
		Property<Address> pds = super.getPropertyDataSource();
		pds.setValue(getAddress());
		return pds;
	}

	@Override
	public void setPropertyDataSource(Property newDataSource) {
		super.setPropertyDataSource(newDataSource);
		setAddress((Address) newDataSource.getValue());
	}

	@Override
	public Class<? extends Address> getType() {
		return Address.class;
	}

	public String getCity() {
		return cityField.getValue();
	}

	public void setCity(String city) {
		this.cityField.setValue(city);
	}

	public String getStreet() {
		return streetField.getValue();
	}

	public void setStreet(String street) {
		this.streetField.setValue(street);
	}

	public Long getNumber() {
		return Long.parseLong(numberField.getValue());
	}

	public void setNumber(Long number) {
		this.numberField.setValue(number + "");
	}

	public Address getAddress() {
		return new Address(getCity(), getStreet(), getNumber());
	}

	public void setAddress(Address value) {
		setCity(value.getCity());
		setStreet(value.getStreet());
		setNumber(value.getNumber());
	}


}
