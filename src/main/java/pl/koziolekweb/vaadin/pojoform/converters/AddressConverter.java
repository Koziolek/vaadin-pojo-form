package pl.koziolekweb.vaadin.pojoform.converters;

import com.vaadin.data.util.converter.Converter;
import pl.koziolekweb.vaadin.pojoform.AddressField;
import pl.koziolekweb.vaadin.pojoform.model.Address;

import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 08.11.13
 * Time: 19:50
 * To change this template use File | Settings | File Templates.
 */
public class AddressConverter implements Converter<AddressField, Address> {


	@Override
	public Address convertToModel(AddressField value, Class<? extends Address> targetType, Locale locale) throws ConversionException {
		return new Address(value.getCity(), value.getStreet(), value.getNumber());
	}

	@Override
	public AddressField convertToPresentation(Address value, Class<? extends AddressField> targetType, Locale locale) throws ConversionException {
		AddressField af = new AddressField();
		if (value != null) {
			af.setCity(value.getCity());
			af.setStreet(value.getStreet());
			af.setNumber(value.getNumber());
		}
		return af;
	}

	@Override
	public Class<Address> getModelType() {
		return Address.class;
	}

	@Override
	public Class<AddressField> getPresentationType() {
		return AddressField.class;
	}
}
