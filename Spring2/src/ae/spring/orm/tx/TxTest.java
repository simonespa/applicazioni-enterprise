package ae.spring.orm.tx;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ae.spring.orm.tx.dao.SiteDao;
import ae.spring.orm.tx.dao.WebPageDao;
import ae.spring.orm.tx.dto.Site;
import ae.spring.orm.tx.dto.WebPage;

public class TxTest {
	private static ApplicationContext context;

	private static SiteDao siteDao;

	private static WebPageDao webPageDao;

	@BeforeClass
	public static void init() {
		context = new ClassPathXmlApplicationContext("ae/spring/orm/tx/applicationContext.xml");
		siteDao = context.getBean("siteDao", SiteDao.class);
		webPageDao = context.getBean("webPageDao", WebPageDao.class);
	}

	private Site site;

	private WebPage webPage;

	@Test
	public void deleteSite() {
		siteDao.delete(site);

		final Collection<Site> list = siteDao.getSites();
		assertThat(list.size(), is(equalTo(0)));

		final Collection<WebPage> list2 = webPageDao.getWebPages();
		assertThat(list2, hasSize(0));
	}

	@Test(expected = NullPointerException.class)
	public void deleteSiteWithError() {
		siteDao.deleteWithError(site);

		final Collection<Site> list = siteDao.getSites();
		assertThat(list.size(), is(equalTo(1)));

		final Collection<WebPage> list2 = webPageDao.getWebPages();
		assertThat(list2, hasSize(5));
	}

	@Before
	public void loaddb() {
		site = createSite("site", "url");
		siteDao.save(site);
		for (int i = 0; i < 4; i++) {
			webPageDao.save(createWebPage(site, "url_wp_" + i));
		}
		webPage = createWebPage(site, "url_wpX");
		webPageDao.save(webPage);
	}

	private Site createSite(final String name, final String url) {
		final Site site = new Site();
		site.setName(name);
		site.setUrl(url);
		return site;
	}

	private WebPage createWebPage(final Site site, final String url) {
		final WebPage webPage = new WebPage();
		webPage.setSite(site);
		webPage.setUrl(url);

		site.addWebPage(webPage);
		return webPage;
	}
}
