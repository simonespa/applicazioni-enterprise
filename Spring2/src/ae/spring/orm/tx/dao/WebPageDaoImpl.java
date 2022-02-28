package ae.spring.orm.tx.dao;

import java.util.Collection;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import ae.spring.orm.tx.dto.WebPage;

public class WebPageDaoImpl extends HibernateDaoSupport implements WebPageDao
{
    @Override
    @Transactional
    public void delete(final WebPage webPage)
    {
        getHibernateTemplate().delete(webPage);
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public Collection<WebPage> getByProperty(final String property, final Object value)
    {
        final String queryString = String.format("from WebPage where %s = ? ", property);
        return getHibernateTemplate().find(queryString, value);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<WebPage> getWebPages()
    {
        return getHibernateTemplate().loadAll(WebPage.class);
    }

    @Override
    @Transactional
    public void save(final WebPage webPage)
    {
        getHibernateTemplate().save(webPage);
    }

    @Override
    @Transactional()
    public void update(final WebPage webPage)
    {
        getHibernateTemplate().update(webPage);
    }
}
