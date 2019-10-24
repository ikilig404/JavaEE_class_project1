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
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Connection;

public class AOPTest {
    private ConfigurableApplicationContext ctx;
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

    @AfterEach
    public void closeContext() {
        ctx.close();
    }

    /**
     * 测试数据库和数据源配置是否正确
     * @throws Exception
     */
    @Test
    public void testDataSource() throws Exception {
        System.out.println(ctx);
        Connection connection = ds.getConnection();
        System.out.println(connection);
        System.out.println(template);
    }

    /**
     * 测试CRUD操作是否正常
     */
    @Test
    public void testCRUD() {
        String sql = "insert into course (name, score) values (?,?)";
        template.update(sql, "如来神掌", 40);
    }

    @Test
    public void testStudentServiceImpl() {
        int score = iStudentService.queryCourseScore(1);
        System.out.println(score);
    }

    @Test
    public void testTx () {
        // 选课的同学持有的积分
        int studentScore = iStudentService.queryStudentScore(1);
        // 要选择的课程所消耗的积分
        int courseScore = iStudentService.queryCourseScore(2);

        // 以下被注释的判断可以放到前置通知去做
//        if (studentScore < courseScore) {
//            System.out.println("积分不足");
//        } else {
//
//        }
        iStudentService.updateStudentScore(1, studentScore, courseScore);
        iStudentService.insertIntoStudentCourse(1, 2);
    }
}
