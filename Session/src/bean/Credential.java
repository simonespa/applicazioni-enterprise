package bean;

import javax.validation.constraints.Size;

public class Credential {

	@Size(min = 1, message="Suca email")
	private String email;
	@Size(min = 1, message="Suca password")
	private String password;

	public Credential() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
