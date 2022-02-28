package ae.spring.aop.pojo;

import java.util.Arrays;

public abstract class Product
{
    private static final long serialVersionUID = 1L;

    private String author;

    private byte[] cover;

    private Double price;

    private Long productId;

    private String title;

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
        if (price == null)
        {
            if (other.price != null)
            {
                return false;
            }
        }
        else if (!price.equals(other.price))
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

    public String getAuthor()
    {
        return author;
    }

    public byte[] getCover()
    {
        return cover;
    }

    public Double getPrice()
    {
        return price;
    }

    public Long getProductId()
    {
        return productId;
    }

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
        result = prime * result + (price == null ? 0 : price.hashCode());
        result = prime * result + (productId == null ? 0 : productId.hashCode());
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

    public void setPrice(final Double price)
    {
        this.price = price;
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
        return "Product [author=" + author + ", cover=" + Arrays.toString(cover) + ", price=" + price + ", productId="
                + productId + ", title=" + title + "]";
    }
}
