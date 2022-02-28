package ae.spring.orm.musicstore.dao;

import java.util.Set;

import ae.spring.orm.musicstore.dto.Customer;
import ae.spring.orm.musicstore.dto.MusicCard;

public interface MusicCardDao extends BaseDao<MusicCard, Long>
{
    Set<String> getPromotionByCustomer(Customer customer);
}
