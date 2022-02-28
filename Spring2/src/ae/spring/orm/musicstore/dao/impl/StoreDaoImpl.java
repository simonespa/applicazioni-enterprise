package ae.spring.orm.musicstore.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.transaction.annotation.Transactional;

import ae.spring.orm.musicstore.dao.StoreDao;
import ae.spring.orm.musicstore.dto.Product;
import ae.spring.orm.musicstore.dto.Store;

public class StoreDaoImpl extends BaseDaoImpl<Store, Long> implements StoreDao
{
    public StoreDaoImpl()
    {
        super(Store.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Store findUniqueByExample(final Store store)
    {
        final List<Store> list = getHibernateTemplate().findByCriteria(
                DetachedCriteria.forClass(Store.class).add(
                        Example.create(store).enableLike(MatchMode.ANYWHERE).ignoreCase().excludeZeroes()));
        if (list.size() != 1)
        {
            throw new RuntimeException("Not unique result");
        }
        return list.get(0);
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Store> getDistinctStoreByProduct(final Product product, final String order, final int first, final int size)
    {
        return getHibernateTemplate().executeFind(new HibernateCallback<List<Store>>()
            {
                @Override
                public List<Store> doInHibernate(final Session session) throws HibernateException, SQLException
                {
                    final String queryString = String.format(
                            "select distinct p.stores from Product p where p.productId=? order by %s", order);
                    final Query query = session.createQuery(queryString);
                    query.setLong(0, product.getProductId());
                    query.setFirstResult(first);
                    query.setMaxResults(size);
                    return query.list();
                }
            });
    }

    @Override
    public void removeChildren(final Store store)
    {
        for (final Product product : store.getProducts())
        {
            product.getStores().remove(store);
        }
    }
}
