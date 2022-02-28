package ae.spring.orm.base.dao;

import java.util.Collection;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ae.spring.orm.base.dto.UserAccount;

public class UserAccountDaoImpl extends HibernateDaoSupport implements UserAccountDao
{
    @Override
    public void delete(final UserAccount userAccount)
    {
        getHibernateTemplate().delete(userAccount);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Collection<UserAccount> getByProperty(final String property, final Object value)
    {
        final String queryString = String.format("from UserAccount where %s = ? ", property);
        return getHibernateTemplate().find(queryString, value);
    }

    @Override
    public Collection<UserAccount> getUserAccounts()
    {
        return getHibernateTemplate().loadAll(UserAccount.class);
    }

    @Override
    public void save(final UserAccount userAccount)
    {
        getHibernateTemplate().save(userAccount);
    }

    @Override
    public void update(final UserAccount userAccount)
    {
        getHibernateTemplate().update(userAccount);
    }
}
