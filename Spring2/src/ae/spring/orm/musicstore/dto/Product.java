package ae.spring.orm.musicstore.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Product")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class Product extends BasePojo
{
    private static final long serialVersionUID = 1L;

    private String author;

    private byte[] cover;

    private Long productId;

    private List<Sale> sales = new ArrayList<Sale>();

    private List<Store> stores = new ArrayList<Store>();

    private String title;

    public void addSale(final Sale sale)
    {
        sales.add(sale);
    }

    public void addStore(final Store store)
    {
        stores.add(store);
    }

    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Product other = (Product) obj;
        if (author == null)
        {
            if (other.author != null)
            {
                return false;
            }
        }
        else if (!author.equals(other.author))
        {
            return false;
        }
        if (!Arrays.equals(cover, other.cover))
        {
            return false;
        }
        if (productId == null)
        {
            if (other.productId != null)
            {
                return false;
            }
        }
        else if (!productId.equals(other.productId))
        {
            return false;
        }
        if (sales == null)
        {
            if (other.sales != null)
            {
                return false;
            }
        }
        else if (!sales.equals(other.sales))
        {
            return false;
        }
        if (stores == null)
        {
            if (other.stores != null)
            {
                return false;
            }
        }
        else if (!stores.equals(other.stores))
        {
            return false;
        }
        if (title == null)
        {
            if (other.title != null)
            {
                return false;
            }
        }
        else if (!title.equals(other.title))
        {
            return false;
        }
        return true;
    }

    @Column(name = "author", length = 128)
    public String getAuthor()
    {
        return author;
    }

    @Lob
    public byte[] getCover()
    {
        return cover;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getProductId()
    {
        return productId;
    }

    @OneToMany(targetEntity = Sale.class, mappedBy = "product")
    @OnDelete(action = OnDeleteAction.CASCADE)
    public List<Sale> getSales()
    {
        return sales;
    }

    @ManyToMany(targetEntity = Store.class, mappedBy = "products")
    public List<Store> getStores()
    {
        return stores;
    }

    @Column(name = "title", length = 128)
    public String getTitle()
    {
        return title;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (author == null ? 0 : author.hashCode());
        result = prime * result + Arrays.hashCode(cover);
        result = prime * result + (productId == null ? 0 : productId.hashCode());
        result = prime * result + (sales == null ? 0 : sales.hashCode());
        result = prime * result + (stores == null ? 0 : stores.hashCode());
        result = prime * result + (title == null ? 0 : title.hashCode());
        return result;
    }

    public abstract ProductKind kind();

    public void setAuthor(final String author)
    {
        this.author = author;
    }

    public void setCover(final byte[] cover)
    {
        this.cover = cover;
    }

    public void setProductId(final Long productId)
    {
        this.productId = productId;
    }

    public void setTitle(final String title)
    {
        this.title = title;
    }

    @Override
    public String toString()
    {
        return "Product [author=" + author + ", cover=" + Arrays.toString(cover) + ", productId=" + productId + ", sales="
                + dumpSales(sales) + ", stores=" + dumpStores(stores) + ", title=" + title + "]";
    }

    private String dumpSales(final List<Sale> sales)
    {
        final List<String> names = new ArrayList<String>();
        for (final Sale sale : sales)
        {
            names.add(sale.getSellingDate().toString());
        }
        return names.toString();
    }

    private String dumpStores(final List<Store> stores)
    {
        final List<String> names = new ArrayList<String>();
        for (final Store store : stores)
        {
            names.add(store.getName());
        }
        return names.toString();
    }

    void setSales(final List<Sale> sales)
    {
        //        this.sales.clear();
        //        this.sales.addAll(sales);
        this.sales = sales;
    }

    void setStores(final List<Store> stores)
    {
        //        this.stores.clear();
        //        this.stores.addAll(stores);
        this.stores = stores;
    }
}
