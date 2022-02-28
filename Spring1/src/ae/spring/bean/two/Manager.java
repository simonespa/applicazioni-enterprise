package ae.spring.bean.two;

public class Manager {

	private String prolog;
	private User user;

	public User getUser() {
		return user;
	}

	public void init() {
		prolog = "Hello: ";
	}

	public void run() {
		System.out.println(prolog);
		user.desc();
	}

	public void setUser(final User user) {
		this.user = user;
	}
}
