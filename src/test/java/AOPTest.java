/**
 * 第二题
 */

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    @Test
    public void testAOP () {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springConfig.xml");

    }
}
