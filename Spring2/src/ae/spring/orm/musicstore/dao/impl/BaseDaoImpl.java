package ae.spring.orm.musicstore.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import ae.spring.orm.musicstore.dao.BaseDao;
import ae.spring.orm.musicstore.dto.BasePojo;

public abstract class BaseDaoImpl<T extends BasePojo, PK extends Serializable> extends HibernateDaoSupport implements
        BaseDao<T, PK>
{
    public final Class<T> persistentClass;

    /**
     * Constructor that takes in a class to see which type of entity to persist
     * @param persistentClass the class type you'd like to persist
     */
    public BaseDaoImpl(final Class<T> persistentClass)
    {
        this.persistentClass = persistentClass;
    }

    @Transactional(readOnly = true)
    @Override
    public int countAll()
    {
        final Long uniqueResult = (Long) getSession().createQuery(
                "select count(*) from " + this.persistentClass.getName() + " obj").uniqueResult();
        return uniqueResult.intValue();

    }

    @Transactional(readOnly = true)
    @Override
    public boolean exists(final PK id)
    {
        final T t = get(id);
        if (t != null)
        {
            return true;
        }
        return false;
    }

    public T findUnique(final String queryString, final Object... values)
    {
        @SuppressWarnings("unchecked")
        final List<T> list = getHibernateTemplate().find(queryString, values);
        if (list.size() != 1)
        {
            throw new RuntimeException("Not unique result");
        }
        return list.get(0);
    }

    @Transactional(readOnly = true)
    @Override
    public T get(final PK id)
    {
        return getHibernateTemplate().get(persistentClass, id);
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<T> getAll()
    {
        return getHibernateTemplate().find("from " + persistentClass.getName());
    }

    @Transactional
    @Override
    public void remove(final T object)
    {
        getHibernateTemplate().execute(new HibernateCallback<Void>()
            {
                @Override
                public Void doInHibernate(final Session session) throws HibernateException, SQLException
                {
                    removeChildren(object);
                    session.delete(object);
                    return null;
                }
            });
    }

    @Transactional
    @Override
    public void save(final T object)
    {
        getHibernateTemplate().saveOrUpdate(object);
        getHibernateTemplate().flush();
    }

    protected void removeChildren(final T object)
    {
    }
}
