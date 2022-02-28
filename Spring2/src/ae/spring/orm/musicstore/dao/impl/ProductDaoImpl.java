package ae.spring.orm.musicstore.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import ae.spring.orm.musicstore.dao.ProductDao;
import ae.spring.orm.musicstore.dto.Cd;
import ae.spring.orm.musicstore.dto.Product;
import ae.spring.orm.musicstore.dto.Store;

public class ProductDaoImpl extends BaseDaoImpl<Product, Long> implements ProductDao
{
    public ProductDaoImpl()
    {
        super(Product.class);
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Cd> getCds()
    {
        return getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(Cd.class));
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Cd> getCdsByAuthor(final String author, final String order)
    {
        final DetachedCriteria criteria = DetachedCriteria.forClass(Cd.class);
        criteria.add(Restrictions.eq("author", author));
        criteria.addOrder(Order.asc(order));
        return getHibernateTemplate().findByCriteria(criteria);
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Product> getProductsByStore(final String storeName, final String order, final int first, final int size)
    {
        final DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
        criteria.createCriteria("stores").add(Restrictions.eq("name", storeName));
        criteria.addOrder(Order.asc(order));
        return getHibernateTemplate().findByCriteria(criteria, first, size);
    }

    @Override
    protected void removeChildren(final Product product)
    {
        System.out.println("Stores of this product: " + product.getStores());
        for (final Store store : product.getStores())
        {
            store.getProducts().remove(product);
        }
        product.getStores().clear();
    }
}
