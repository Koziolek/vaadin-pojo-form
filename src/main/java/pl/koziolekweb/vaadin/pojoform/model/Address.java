package pl.koziolekweb.vaadin.pojoform.model;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 08.11.13
 * Time: 19:12
 * To change this template use File | Settings | File Templates.
 */
public class Address {

	private String city;
	private String street;
	private Long number;

	public Address() {
	}

	public Address(String city, String street, Long number) {
		this.city = city;
		this.street = street;
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Address{" +
				"city='" + city + '\'' +
				", street='" + street + '\'' +
				", number=" + number +
				'}';
	}
}
