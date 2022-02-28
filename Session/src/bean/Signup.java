package bean;

import javax.validation.constraints.Size;

public class Signup {

	@Size(min = 1)
	private String c;
	@Size(min = 1)
	private String d;

	public Signup() {
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

}
