package ae.spring.orm.tx.dao;

import java.util.Collection;

import ae.spring.orm.tx.dto.WebPage;

public interface WebPageDao
{
    public void delete(WebPage webPage);

    public Collection<WebPage> getByProperty(String property, Object value);

    public Collection<WebPage> getWebPages();

    public void save(WebPage webPage);

    public void update(WebPage webPage);
}
