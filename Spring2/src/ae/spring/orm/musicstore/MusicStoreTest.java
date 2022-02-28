package ae.spring.orm.musicstore;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ae.spring.orm.musicstore.dto.Cd;
import ae.spring.orm.musicstore.dto.Customer;
import ae.spring.orm.musicstore.dto.Employee;
import ae.spring.orm.musicstore.dto.Mc;
import ae.spring.orm.musicstore.dto.MusicCard;
import ae.spring.orm.musicstore.dto.Product;
import ae.spring.orm.musicstore.dto.Sale;
import ae.spring.orm.musicstore.dto.Store;

@RunWith(SpringJUnit4ClassRunner.class)
//ApplicationContext will be loaded from "/applicationContext.xml" in the root of the classpath
@ContextConfiguration(locations = { "/applicationContext.xml" })
@Transactional
public class MusicStoreTest extends AbstractTransactionalJUnit4SpringContextTests
{
    private Product cd1;

    @Autowired
    private DaoManager daoManager;

    private Store store1;

    @Test
    public void changeAddressAtStore()
    {
        final String newAddress = "new address";
        final Store store = daoManager.getStoreDao().get(store1.getStoreId());
        store.setAddress(newAddress);
        daoManager.getStoreDao().save(store);

        final Store store2 = daoManager.getStoreDao().get(store1.getStoreId());
        assertThat(store2.getAddress(), is(equalTo(newAddress)));
    }

    @Test
    public void deleteAllProducts()
    {
        for (final Product product : daoManager.getProductDao().getAll())
        {
            daoManager.getProductDao().remove(product);
        }

        final List<Product> products = daoManager.getProductDao().getAll();
        assertThat(products.size(), is(equalTo(0)));

        final List<Sale> sales = daoManager.getSaleDao().getAll();
        assertThat(sales.size(), is(equalTo(0)));

        final List<Store> stores = daoManager.getStoreDao().getAll();
        assertThat(stores.size(), is(equalTo(2)));
        for (final Store store : stores)
        {
            assertThat(store.getProducts().size(), is(equalTo(0)));
        }

        final List<Customer> customers = daoManager.getCustomerDao().getAll();
        assertThat(customers.size(), is(equalTo(3)));
    }

    @Test
    public void deleteAllSales()
    {
        for (final Sale sale : daoManager.getSaleDao().getAll())
        {
            daoManager.getSaleDao().remove(sale);
        }
        assertThat(daoManager.getSaleDao().getAll(), hasSize(0));
    }

    @Test
    public void deleteAllStores()
    {
        for (final Store store : daoManager.getStoreDao().getAll())
        {
            daoManager.getStoreDao().remove(store);
        }

        assertThat(daoManager.getStoreDao().getAll(), hasSize(0));

        assertThat(daoManager.getSaleDao().getAll(), hasSize(0));

        assertThat(daoManager.getEmployeeDao().getAll(), hasSize(0));

        final List<Product> products = daoManager.getProductDao().getAll();
        assertThat(products, hasSize(8));
        for (final Product product : products)
        {
            assertThat(product.getStores().size(), is(equalTo(0)));
        }

        final List<Customer> customers = daoManager.getCustomerDao().getAll();
        assertThat(customers, hasSize(3));
    }

    @Test
    public void deleteStore1()
    {
        daoManager.getStoreDao().remove(store1);
    }

    @Test
    public void findAllCd()
    {
        final List<Cd> cds = daoManager.getProductDao().getCds();
        assertThat(cds, hasSize(5));
    }

    @Test
    public void findAllCdOfPinkFloyd()
    {
        final List<Cd> list = daoManager.getProductDao().getCdsByAuthor("Pink Floyd", "title");
        assertThat(list, hasSize(4));
    }

    @Test
    public void findAllCustomersThatBuyCdOfPinkFloyd()
    {
        final List<Customer> customers = daoManager.getCustomerDao().getCustomersThatBuyCdOfArtist("Pink Floyd");
        assertThat(customers, hasSize(1));
    }

    @Test
    public void findAllCustomersThatBuyProductOfPinkFloyd()
    {
        final List<Customer> customers = daoManager.getCustomerDao().getCustomersThatBuyProductOfArtist("Pink Floyd");
        assertThat(customers, hasSize(2));
    }

    @Test
    public void findAllCustomersThatBuyProductOfPinkFloydWithCriteria()
    {
        final List<Customer> customers = daoManager.getCustomerDao().getCustomersThatBuyProductOfArtistByCriteria("Pink Floyd");
        assertThat(customers, hasSize(2));
    }

    @Test
    public void findAllDistinctStoreOfAProductWithQuery()
    {
        assertThat(daoManager.getStoreDao().getDistinctStoreByProduct(cd1, "address", 0, 5), hasSize(2));
        assertThat(daoManager.getStoreDao().getDistinctStoreByProduct(cd1, "address", 1, 1), hasSize(1));
    }

    @Test
    public void findAllMusicCard()
    {
        final List<MusicCard> all = daoManager.getMusicCardDao().getAll();
        for (final MusicCard musicCard : all)
        {
            System.out.println(musicCard.getPromotions().size());
        }
        assertThat(all, hasSize(3));
    }

    @Test
    public void findAllProductOfAStore()
    {
        assertThat(daoManager.getProductDao().getProductsByStore("store2", "author", 0, 10), hasSize(7));
        assertThat(daoManager.getProductDao().getProductsByStore("store2", "author", 4, 2), hasSize(2));
    }

    @Test
    public void findAllPromotions()
    {
        final Customer customer = daoManager.getCustomerDao().getCustomerByEmail("email@1.xx");
        assertThat(customer, is(notNullValue()));

        final Set<String> promotions = daoManager.getMusicCardDao().getPromotionByCustomer(customer);
        assertThat(promotions, hasSize(2));
    }

    @Test
    public void findByExample()
    {
        final Store storeExample = createStore("address", "2");
        final Store store = daoManager.getStoreDao().findUniqueByExample(storeExample);
        assertThat(store, is(notNullValue()));
        assertThat(store.getName(), is(equalTo("store2")));
    }

    @Before
    public void loadDb()
    {
        cd1 = createCd("Pink Floyd", "The Wall", new byte[0]);
        final Product cd2 = createCd("Pink Floyd", "The dark side of the moon", new byte[0]);
        final Product cd3 = createCd("Vasco Rossi", "Canzoni per me", new byte[0]);
        final Product cd4 = createCd("Pink Floyd", "Wish You Were Here", new byte[0]);
        final Product cd5 = createCd("Pink Floyd", "Animals", new byte[0]);
        final Product mc1 = createMc("Pink Floyd", "Ummagumma", new byte[0]);
        final Product mc2 = createMc("Vasco Rossi", "Stupido Hotel", new byte[0]);
        final Product mc3 = createMc("ACDC", "Back in Black", new byte[0]);
        daoManager.getProductDao().save(cd1);
        daoManager.getProductDao().save(cd2);
        daoManager.getProductDao().save(cd3);
        daoManager.getProductDao().save(cd4);
        daoManager.getProductDao().save(cd5);
        daoManager.getProductDao().save(mc1);
        daoManager.getProductDao().save(mc2);
        daoManager.getProductDao().save(mc3);

        store1 = createStore("address_store1", "store1");
        addProductAtStore(store1, cd1, cd2, cd1, mc1, mc1);
        daoManager.getStoreDao().save(store1);
        final Store store2 = createStore("address_store2", "store2");
        addProductAtStore(store2, cd1, cd1, mc3, mc1, mc1, cd2, mc3);
        daoManager.getStoreDao().save(store2);

        final Employee employee1 = createEmployee("employee1 firstname", "employee1 lastname", 1200D, store2);
        daoManager.getEmployeeDao().save(employee1);
        final Employee employee2 = createEmployee("employee2 firstname", "employee2 lastname", 1200D, store2);
        daoManager.getEmployeeDao().save(employee2);
        final Employee employee3 = createEmployee("employee3 firstname", "employee3 lastname", 1200D, store2);
        daoManager.getEmployeeDao().save(employee3);
        final Employee employee4 = createEmployee("employee4 firstname", "employee4 lastname", 1200D, store1);
        daoManager.getEmployeeDao().save(employee4);

        final MusicCard musicCard1 = createMusicCard("1234", "red", "yellow");
        daoManager.getMusicCardDao().save(musicCard1);
        final Customer customer1 = createCustomer("firstname1", "lastname1", "address1", "email@1.xx", "111111", musicCard1);
        daoManager.getCustomerDao().save(customer1);

        final MusicCard musicCard2 = createMusicCard("5678", "red");
        daoManager.getMusicCardDao().save(musicCard2);
        final Customer customer2 = createCustomer("firstname2", "lastname2", "address2", "email@2.xx", "2222222", musicCard2);
        daoManager.getCustomerDao().save(customer2);

        final MusicCard musicCard3 = createMusicCard("90000", "green");
        daoManager.getMusicCardDao().save(musicCard3);
        final Customer customer3 = createCustomer("firstname3", "lastname3", "address3", "email@3.xx", "3333333", musicCard3);
        daoManager.getCustomerDao().save(customer3);

        final Sale sale1 = createSale(store1, cd1, customer2, new Date());
        daoManager.getSaleDao().save(sale1);

        final Sale sale2 = createSale(store1, mc1, customer1, new Date());
        daoManager.getSaleDao().save(sale2);

        final Sale sale3 = createSale(store2, mc2, customer3, new Date());
        daoManager.getSaleDao().save(sale3);
    }

    private void addProductAtStore(final Store store, final Product... products)
    {
        store.getProducts().clear();
        store.getProducts().addAll(Arrays.asList(products));
        for (final Product product : products)
        {
            product.addStore(store);
        }
    }

    private Product createCd(final String author, final String title, final byte[] cover)
    {
        final Product cd = new Cd();
        cd.setAuthor(author);
        cd.setTitle(title);
        cd.setCover(cover);
        return cd;
    }

    private Customer createCustomer(final String firstname, final String lastname, final String address, final String email,
            final String telephone, final MusicCard musicCard)
    {
        final Customer customer = new Customer();
        customer.setFirstname(firstname);
        customer.setLastname(lastname);
        customer.setAddress(address);
        customer.setEmail(email);
        customer.setTelephone(telephone);
        customer.setMusicCard(musicCard);

        musicCard.setCustomer(customer);
        return customer;
    }

    private Employee createEmployee(final String firstname, final String lastname, final double salary, final Store store)
    {
        final Employee employee;
        employee = new Employee();
        employee.setFirstname(firstname);
        employee.setLastname(lastname);
        employee.setSalary(salary);
        employee.setStore(store);

        store.addEmployee(employee);
        return employee;
    }

    private Product createMc(final String author, final String title, final byte[] cover)
    {
        final Product mc = new Mc();
        mc.setAuthor(author);
        mc.setTitle(title);
        mc.setCover(cover);
        return mc;
    }

    private MusicCard createMusicCard(final String code, final String... promotions)
    {
        final MusicCard musicCard = new MusicCard();
        musicCard.setCode(code);
        musicCard.setPromotions(new HashSet<String>(Arrays.asList(promotions)));
        return musicCard;
    }

    private Sale createSale(final Store store, final Product cd, final Customer customer, final Date sellingDate)
    {
        final Sale sale = new Sale();
        sale.setCustomer(customer);
        sale.setProduct(cd);
        sale.setStore(store);
        sale.setSellingDate(sellingDate);

        store.addSale(sale);
        cd.addSale(sale);
        customer.addSale(sale);

        return sale;
    }

    private Store createStore(final String address, final String name)
    {
        final Store store1 = new Store();
        store1.setAddress(address);
        store1.setName(name);
        return store1;
    }
}
