package ae.spring.orm.tx.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "webpage")
public class WebPage
{
    private Site site;

    private String url;

    private Long webPageId;

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
        final WebPage other = (WebPage) obj;
        if (site == null)
        {
            if (other.site != null)
            {
                return false;
            }
        }
        else if (!site.equals(other.site))
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
        if (webPageId == null)
        {
            if (other.webPageId != null)
            {
                return false;
            }
        }
        else if (!webPageId.equals(other.webPageId))
        {
            return false;
        }
        return true;
    }

    @ManyToOne()
    @JoinColumn(name = "site")
    public Site getSite()
    {
        return site;
    }

    @Column(name = "url", length = 255, unique = true, nullable = false)
    public String getUrl()
    {
        return url;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long getWebPageId()
    {
        return webPageId;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (site == null ? 0 : site.hashCode());
        result = prime * result + (url == null ? 0 : url.hashCode());
        result = prime * result + (webPageId == null ? 0 : webPageId.hashCode());
        return result;
    }

    public void setSite(final Site site)
    {
        this.site = site;
    }

    public void setUrl(final String url)
    {
        this.url = url;
    }

    public void setWebPageId(final Long webPageId)
    {
        this.webPageId = webPageId;
    }

    @Override
    public String toString()
    {
        return "WebPage [site=" + site + ", url=" + url + ", webPageId=" + webPageId + "]";
    }

}
