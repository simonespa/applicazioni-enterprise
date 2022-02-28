package ae.spring.orm.musicstore;

import ae.spring.orm.musicstore.dao.CustomerDao;
import ae.spring.orm.musicstore.dao.EmployeeDao;
import ae.spring.orm.musicstore.dao.MusicCardDao;
import ae.spring.orm.musicstore.dao.ProductDao;
import ae.spring.orm.musicstore.dao.SaleDao;
import ae.spring.orm.musicstore.dao.StoreDao;

public interface DaoManager
{
    CustomerDao getCustomerDao();

    EmployeeDao getEmployeeDao();

    MusicCardDao getMusicCardDao();

    ProductDao getProductDao();

    SaleDao getSaleDao();

    StoreDao getStoreDao();
}
