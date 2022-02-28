package ae.spring.orm.musicstore.dao;

import java.util.List;

import ae.spring.orm.musicstore.dto.Cd;
import ae.spring.orm.musicstore.dto.Product;

public interface ProductDao extends BaseDao<Product, Long>
{
    List<Cd> getCds();

    List<Cd> getCdsByAuthor(String author, String order);

    List<Product> getProductsByStore(final String storeName, final String order, final int first, final int size);

}
