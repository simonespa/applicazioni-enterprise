package ae.spring.orm.musicstore.dao;

import java.util.List;

import ae.spring.orm.musicstore.dto.Customer;

public interface CustomerDao extends BaseDao<Customer, Long>
{
    Customer getCustomerByEmail(String email);

    List<Customer> getCustomersThatBuyCdOfArtist(String artist);

    List<Customer> getCustomersThatBuyProductOfArtist(String artist);

    List<Customer> getCustomersThatBuyProductOfArtistByCriteria(String artist);
}
