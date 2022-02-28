package ae.spring.orm.musicstore.dao.impl;

import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import ae.spring.orm.musicstore.dao.MusicCardDao;
import ae.spring.orm.musicstore.dto.Customer;
import ae.spring.orm.musicstore.dto.MusicCard;

public class MusicCardDaoImpl extends BaseDaoImpl<MusicCard, Long> implements MusicCardDao
{
    public MusicCardDaoImpl()
    {
        super(MusicCard.class);
    }

    @Transactional(readOnly = true)
    @Override
    public Set<String> getPromotionByCustomer(final Customer customer)
    {
        final MusicCard musicCard = findUnique("from MusicCard m where m.customer.customerId=?", customer.getCustomerId());
        return musicCard.getPromotions();
    }
}
