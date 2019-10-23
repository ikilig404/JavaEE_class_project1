/**
 * 第一题的测试
 */

import com.wjwhs.dao.Account;
import com.wjwhs.dao.Person;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class IOCTest {

    @Test
    public void tsetIOC() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springConfig.xml");
        Person person = (Person) applicationContext.getBean("person");
        Account account1 = (Account) applicationContext.getBean("account1");
        Account account2 = (Account) applicationContext.getBean("account2");
        Account account3 = (Account) applicationContext.getBean("account3");
        System.out.println(person);
        System.out.println(account1);
        System.out.println(account2);
        System.out.println(account3);
    }
}
