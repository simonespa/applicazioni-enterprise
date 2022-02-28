package bean;

import javax.validation.constraints.Size;

public class Login {

	@Size(min=1)
	private String a;
	@Size(min = 1)
	private String b;
	
	public Login() {
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}
	
}
