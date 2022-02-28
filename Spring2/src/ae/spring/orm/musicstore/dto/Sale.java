package ae.spring.orm.musicstore.dto;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Sale")
public class Sale extends BasePojo
{
    private static final long serialVersionUID = 1L;

    private Customer customer;

    private Product product;

    private Long saleId;

    private Date sellingDate;

    private Store store;

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
        final Sale other = (Sale) obj;
        if (customer == null)
        {
            if (other.customer != null)
            {
                return false;
            }
        }
        else if (!customer.equals(other.customer))
        {
            return false;
        }
        if (product == null)
        {
            if (other.product != null)
            {
                return false;
            }
        }
        else if (!product.equals(other.product))
        {
            return false;
        }
        if (sellingDate == null)
        {
            if (other.sellingDate != null)
            {
                return false;
            }
        }
        else if (!sellingDate.equals(other.sellingDate))
        {
            return false;
        }
        if (store == null)
        {
            if (other.store != null)
            {
                return false;
            }
        }
        else if (!store.equals(other.store))
        {
            return false;
        }
        return true;
    }

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "customerId")
    public Customer getCustomer()
    {
        return customer;
    }

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "productId")
    public Product getProduct()
    {
        return product;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long getSaleId()
    {
        return saleId;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "sellingDate")
    public Date getSellingDate()
    {
        return sellingDate;
    }

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "storeId")
    public Store getStore()
    {
        return store;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (customer == null ? 0 : customer.hashCode());
        result = prime * result + (product == null ? 0 : product.hashCode());
        result = prime * result + (sellingDate == null ? 0 : sellingDate.hashCode());
        result = prime * result + (store == null ? 0 : store.hashCode());
        return result;
    }

    public void setCustomer(final Customer customer)
    {
        this.customer = customer;
    }

    public void setProduct(final Product product)
    {
        this.product = product;
    }

    public void setSaleId(final Long saleId)
    {
        this.saleId = saleId;
    }

    public void setSellingDate(final Date sellingDate)
    {
        this.sellingDate = sellingDate;
    }

    public void setStore(final Store store)
    {
        this.store = store;
    }

    @Override
    public String toString()
    {
        return "Sale [customer=" + customer + ", product=" + product + ", sellingDate=" + sellingDate + ", store=" + store + "]";
    }

}
