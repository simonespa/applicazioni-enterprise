package ae.spring.bean.five;

public class User {

	private String firstname;
	private String lastname;

	public User() {
	}

	public User(final String firstname, final String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public void desc() {
		System.out.println(String.format("Firstname: %s, Lastname: %s", firstname, lastname));
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setFirstname(final String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(final String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "User [firstname=" + firstname + ", lastname=" + lastname + "]";
	}
}
