/**
 * 第二题
 */

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.wjwhs.service.IStudentService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;

public class AOPTest {
    private ConfigurableApplicationContext ctx;
//    private ApplicationContext applicationContext;
    private ComboPooledDataSource ds;
    private JdbcTemplate template;
    private IStudentService iStudentService;

    @BeforeEach
    public void init() {
        ctx = new ClassPathXmlApplicationContext("springConfig.xml");
        ds = ctx.getBean("dataSource", ComboPooledDataSource.class);
        template = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
        iStudentService = ctx.getBean("studentServiceImpl", IStudentService.class);
    }

    @Test
    public void testDataSource() throws Exception {
        System.out.println(ctx);
        Connection connection = ds.getConnection();
        System.out.println(connection);
        System.out.println(template);

    }

    @Test
    public void testAOP () {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springConfig.xml");

    }
}
