package ae.spring.orm.tx.dao;

import java.util.Collection;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import ae.spring.orm.tx.dto.Site;

public class SiteDaoImpl extends HibernateDaoSupport implements SiteDao
{
    @Override
    @Transactional
    public void delete(final Site site)
    {
        getHibernateTemplate().delete(site);
    }

    //    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { NullPointerException.class })
    @Transactional()
    @Override
    public void deleteWithError(final Site site)
    {
        getHibernateTemplate().delete(site);

        //operation
        final int[] a = null;
        @SuppressWarnings({ "null", "unused" })
        final int i = a[0];

        //operation
        System.out.println("Ciao");
    }

    @SuppressWarnings("unchecked")
    @Override
    public Collection<Site> getByProperty(final String property, final Object value)
    {
        final String queryString = String.format("from Site where %s = ? ", property);
        return getHibernateTemplate().find(queryString, value);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Site> getSites()
    {
        return getHibernateTemplate().loadAll(Site.class);
    }

    @Override
    @Transactional
    public void save(final Site site)
    {
        getHibernateTemplate().save(site);
    }

    @Override
    @Transactional
    public void update(final Site site)
    {
        getHibernateTemplate().update(site);
    }
}
