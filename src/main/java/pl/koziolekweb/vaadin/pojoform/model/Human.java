package pl.koziolekweb.vaadin.pojoform.model;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 08.11.13
 * Time: 19:12
 * To change this template use File | Settings | File Templates.
 */
public class Human {

	private String firstName;
	private String lastName;
	private Address address;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Human{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", address=" + address +
				'}';
	}
}
