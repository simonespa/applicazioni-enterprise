package ae.spring.bean.four;

public class UserAccount {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserAccount [name=" + name + "]";
	}
}
