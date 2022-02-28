package ae.spring.orm.musicstore;

import ae.spring.orm.musicstore.dao.CustomerDao;
import ae.spring.orm.musicstore.dao.EmployeeDao;
import ae.spring.orm.musicstore.dao.MusicCardDao;
import ae.spring.orm.musicstore.dao.ProductDao;
import ae.spring.orm.musicstore.dao.SaleDao;
import ae.spring.orm.musicstore.dao.StoreDao;

public class DaoManagerImpl implements DaoManager
{
    private CustomerDao customerDao;

    private EmployeeDao employeeDao;

    private MusicCardDao musicCardDao;

    private ProductDao productDao;

    private SaleDao saleDao;

    private StoreDao storeDao;

    @Override
    public CustomerDao getCustomerDao()
    {
        return customerDao;
    }

    @Override
    public EmployeeDao getEmployeeDao()
    {
        return employeeDao;
    }

    @Override
    public MusicCardDao getMusicCardDao()
    {
        return musicCardDao;
    }

    @Override
    public ProductDao getProductDao()
    {
        return productDao;
    }

    @Override
    public SaleDao getSaleDao()
    {
        return saleDao;
    }

    @Override
    public StoreDao getStoreDao()
    {
        return storeDao;
    }

    public void setCustomerDao(final CustomerDao customerDao)
    {
        this.customerDao = customerDao;
    }

    public void setEmployeeDao(final EmployeeDao employeeDao)
    {
        this.employeeDao = employeeDao;
    }

    public void setMusicCardDao(final MusicCardDao musicCardDao)
    {
        this.musicCardDao = musicCardDao;
    }

    public void setProductDao(final ProductDao productDao)
    {
        this.productDao = productDao;
    }

    public void setSaleDao(final SaleDao saleDao)
    {
        this.saleDao = saleDao;
    }

    public void setStoreDao(final StoreDao storeDao)
    {
        this.storeDao = storeDao;
    }
}
