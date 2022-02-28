package ae.spring.orm.musicstore.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import ae.spring.orm.musicstore.dao.CustomerDao;
import ae.spring.orm.musicstore.dto.Customer;

public class CustomerDaoImpl extends BaseDaoImpl<Customer, Long> implements CustomerDao
{
    public CustomerDaoImpl()
    {
        super(Customer.class);
    }

    @Transactional(readOnly = true)
    @Override
    public Customer getCustomerByEmail(final String email)
    {
        return findUnique("from Customer where email=?", email);
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Customer> getCustomersThatBuyCdOfArtist(final String artist)
    {
        return getHibernateTemplate()
                .find("select customer from Sale s " + "where s.product in (from Cd where author=?)", artist);
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Customer> getCustomersThatBuyProductOfArtist(final String artist)
    {
        return getHibernateTemplate().find("select customer from Sale s where s.product.author=?", artist);
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Customer> getCustomersThatBuyProductOfArtistByCriteria(final String artist)
    {
        final DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class).createCriteria("sales")
                .createCriteria("product").add(Restrictions.eq("author", artist));
        return getHibernateTemplate().findByCriteria(criteria);
    }

}
