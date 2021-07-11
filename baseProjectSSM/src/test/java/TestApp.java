import edu.cczu.domain.User;
import edu.cczu.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author iceorangeduxiaocheng@aliyun.com
 * @date 2021/7/11 21:37
 */
public class TestApp {

    @Test
    public void test01(){
        String[] resources = {"spring-db.xml", "spring-mvc.xml", "spring-mybatis.xml"
                            ,"spring-service.xml", "spring-tx.xml"};

        ApplicationContext ctx = new ClassPathXmlApplicationContext(resources);
        UserService userService = ctx.getBean("userService", UserService.class);
        List<User> users = userService.queryAllInfo();
        System.out.println(users);
    }
}
