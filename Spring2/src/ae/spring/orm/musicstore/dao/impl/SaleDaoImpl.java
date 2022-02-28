package ae.spring.orm.musicstore.dao.impl;

import ae.spring.orm.musicstore.dao.SaleDao;
import ae.spring.orm.musicstore.dto.Sale;

public class SaleDaoImpl extends BaseDaoImpl<Sale, Long> implements SaleDao
{
    public SaleDaoImpl()
    {
        super(Sale.class);
    }
}
