package ae.spring.orm.tx.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "site")
public class Site
{
    private String name;

    private Long siteId;

    private String url;

    private List<WebPage> webPages = new ArrayList<WebPage>();

    public void addWebPage(final WebPage webPage)
    {
        webPages.add(webPage);
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
        final Site other = (Site) obj;
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
        if (siteId == null)
        {
            if (other.siteId != null)
            {
                return false;
            }
        }
        else if (!siteId.equals(other.siteId))
        {
            return false;
        }
        if (url == null)
        {
            if (other.url != null)
            {
                return false;
            }
        }
        else if (!url.equals(other.url))
        {
            return false;
        }
        if (webPages == null)
        {
            if (other.webPages != null)
            {
                return false;
            }
        }
        else if (!webPages.equals(other.webPages))
        {
            return false;
        }
        return true;
    }

    @Column(name = "name", length = 128)
    public String getName()
    {
        return name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long getSiteId()
    {
        return siteId;
    }

    @Column(name = "url", length = 255, unique = true, nullable = false)
    public String getUrl()
    {
        return url;
    }

    @OneToMany(mappedBy = "site")
    @OnDelete(action = OnDeleteAction.CASCADE)
    public List<WebPage> getWebPages()
    {
        return webPages;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (name == null ? 0 : name.hashCode());
        result = prime * result + (siteId == null ? 0 : siteId.hashCode());
        result = prime * result + (url == null ? 0 : url.hashCode());
        result = prime * result + (webPages == null ? 0 : webPages.hashCode());
        return result;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public void setSiteId(final Long siteId)
    {
        this.siteId = siteId;
    }

    public void setUrl(final String url)
    {
        this.url = url;
    }

    public void setWebPages(final List<WebPage> webPages)
    {
        this.webPages = webPages;
    }

    @Override
    public String toString()
    {
        return "Site [name=" + name + ", siteId=" + siteId + ", url=" + url + ", webPages=" + webPages + "]";
    }
}
