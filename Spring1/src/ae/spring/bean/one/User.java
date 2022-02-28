package ae.spring.bean.one;

public class User {
	
	private String firstname;
	private String lastname;

	public User() {
	}

	public User(final String firstname, final String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String desc() {
		final String format = String.format("Firstname: %s, Lastname: %s", firstname, lastname);
		System.out.println(format);
		return format;
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
}