package ae.spring.orm.base.dao;

import java.util.Collection;

import ae.spring.orm.base.dto.UserAccount;

public interface UserAccountDao
{
    public void delete(UserAccount userAccount);

    public Collection<UserAccount> getByProperty(String property, Object value);

    public Collection<UserAccount> getUserAccounts();

    public void save(UserAccount userAccount);

    public void update(UserAccount userAccount);
}
