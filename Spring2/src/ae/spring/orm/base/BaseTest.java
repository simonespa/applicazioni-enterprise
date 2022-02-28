package ae.spring.orm.base;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ae.spring.orm.base.dao.UserAccountDao;
import ae.spring.orm.base.dto.UserAccount;

public class BaseTest
{
    private static ApplicationContext context;

    @BeforeClass
    public static void init()
    {
        context = new ClassPathXmlApplicationContext("ae/spring/orm/base/applicationContext.xml");
    }

    @Test
    public void test()
    {
        final UserAccountDao userAccountDao = context.getBean("userAccountDao", UserAccountDao.class);

        for (int i = 0; i < 5; i++)
        {
            final UserAccount userAccount = createUserAccount("user_" + i, "password_" + i, i + "@email.it", new Date(), i + 1000);
            userAccountDao.save(userAccount);
        }

        Collection<UserAccount> userAccounts = userAccountDao.getUserAccounts();
        assertThat(userAccounts, hasSize(5));

        userAccountDao.delete(userAccounts.iterator().next());

        userAccounts = userAccountDao.getUserAccounts();
        assertThat(userAccounts, hasSize(4));

    }

    private UserAccount createUserAccount(final String username, final String password, final String email,
            final Date registrationDate, final int score)
    {
        final UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setEmail(email);
        userAccount.setRegistrationDate(registrationDate);
        userAccount.setPhoto(new byte[0]);
        userAccount.setScore(score);
        return userAccount;
    }
}
