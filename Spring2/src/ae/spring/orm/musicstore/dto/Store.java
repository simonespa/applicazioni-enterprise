package ae.spring.orm.musicstore.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "store")
public class Store extends BasePojo
{
    private static final long serialVersionUID = 1L;

    private String address;

    private List<Employee> employees = new ArrayList<Employee>();

    private String name;

    private List<Product> products = new ArrayList<Product>();

    private List<Sale> sales = new ArrayList<Sale>();

    private Long storeId;

    public void addEmployee(final Employee employee)
    {
        employees.add(employee);

    }

    public void addSale(final Sale sale)
    {
        sales.add(sale);
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
        final Store other = (Store) obj;
        if (address == null)
        {
            if (other.address != null)
            {
                return false;
            }
        }
        else if (!address.equals(other.address))
        {
            return false;
        }
        if (employees == null)
        {
            if (other.employees != null)
            {
                return false;
            }
        }
        else if (!employees.equals(other.employees))
        {
            return false;
        }
        if (name == null)
        {
            if (other.name != null)
            {
                return false;
            }
        }
        else if (!name.equals(other.name))
        {
            return false;
        }
        if (products == null)
        {
            if (other.products != null)
            {
                return false;
            }
        }
        else if (!products.equals(other.products))
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
        if (storeId == null)
        {
            if (other.storeId != null)
            {
                return false;
            }
        }
        else if (!storeId.equals(other.storeId))
        {
            return false;
        }
        return true;
    }

    @Column(name = "address", length = 255)
    public String getAddress()
    {
        return address;
    }

    @OneToMany(mappedBy = "store")
    @OnDelete(action = OnDeleteAction.CASCADE)
    public List<Employee> getEmployees()
    {
        return employees;
    }

    @Column(name = "name", length = 128)
    public String getName()
    {
        return name;
    }

    @ManyToMany()
    @JoinTable(name = "stock", joinColumns = @JoinColumn(name = "storeId"), inverseJoinColumns = @JoinColumn(name = "productId"))
    public List<Product> getProducts()
    {
        return products;
    }

    @OneToMany(targetEntity = Sale.class, mappedBy = "store")
    @OnDelete(action = OnDeleteAction.CASCADE)
    public List<Sale> getSales()
    {
        return sales;
    }

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getStoreId()
    {
        return storeId;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (address == null ? 0 : address.hashCode());
        result = prime * result + (employees == null ? 0 : employees.hashCode());
        result = prime * result + (name == null ? 0 : name.hashCode());
        result = prime * result + (products == null ? 0 : products.hashCode());
        result = prime * result + (sales == null ? 0 : sales.hashCode());
        result = prime * result + (storeId == null ? 0 : storeId.hashCode());
        return result;
    }

    public void setAddress(final String address)
    {
        this.address = address;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public void setStoreId(final Long storeId)
    {
        this.storeId = storeId;
    }

    @Override
    public String toString()
    {
        return "Store [address=" + address + ", employees=" + employees + ", name=" + name + ", products="
                + dumpProducts(products) + ", sales=" + dumpSales(sales) + ", storeId=" + storeId + "]";
    }

    private String dumpProducts(final List<Product> products)
    {
        final List<String> names = new ArrayList<String>();
        for (final Product product : products)
        {
            names.add(product.getTitle());
        }
        return names.toString();
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

    void setEmployees(final List<Employee> employees)
    {
        //        this.employees.clear();
        //        this.employees.addAll(employees);
        this.employees = employees;
    }

    void setProducts(final List<Product> products)
    {
        //        this.products.clear();
        //        this.products.addAll(products);
        this.products = products;
    }

    void setSales(final List<Sale> sales)
    {
        //        this.sales.clear();
        //        this.sales.addAll(sales);
        this.sales = sales;
    }
}
