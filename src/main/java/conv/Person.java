package conv;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = -7584575519862872872L;
	long id;			// JPA identity?
	String firstName;
	String lastName;

	public Person(long id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

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
}
