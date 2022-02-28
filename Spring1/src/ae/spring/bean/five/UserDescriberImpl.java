package ae.spring.bean.five;

public class UserDescriberImpl implements UserDescriber {
	
	@Override
	public String describe(final User user) {
		return user.getFirstname() + " " + user.getLastname();
	}
	
}