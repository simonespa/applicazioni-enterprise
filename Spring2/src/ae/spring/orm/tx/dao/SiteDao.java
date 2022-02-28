package ae.spring.orm.tx.dao;

import java.util.Collection;

import ae.spring.orm.tx.dto.Site;

public interface SiteDao
{
    public void delete(Site site);

    public void deleteWithError(Site site);

    public Collection<Site> getByProperty(String property, Object value);

    public Collection<Site> getSites();

    public void save(Site site);

    public void update(Site site);
}
