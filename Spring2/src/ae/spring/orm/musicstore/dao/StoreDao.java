package ae.spring.orm.musicstore.dao;

import java.util.List;

import ae.spring.orm.musicstore.dto.Product;
import ae.spring.orm.musicstore.dto.Store;

public interface StoreDao extends BaseDao<Store, Long>
{
    Store findUniqueByExample(Store store);

    List<Store> getDistinctStoreByProduct(Product product, String order, int first, int size);
}
