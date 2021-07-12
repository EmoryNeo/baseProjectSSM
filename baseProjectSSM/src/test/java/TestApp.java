import edu.cczu.base.domain.admin.User;
import edu.cczu.base.service.admin.IUserService;
import edu.cczu.base.utils.MD5Util;
import edu.cczu.base.utils.UUIDUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.UUID;

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
        IUserService userService = ctx.getBean("userService", IUserService.class);
        User user = new User();
        user.setId(UUIDUtil.getUUID());
        user.setUsername("SMITH");
        user.setPassword(MD5Util.getMD5("123"));
        user.setPhone("19802676240");
        user.setAge("22");
        user.setEmail("iceorangeduxiaocheng@aliyun.com");
        user.setGender("1");
        user.setPhoto(null);
        user.setAddress("New_York");
        Integer result = userService.registerUser(user);
        System.out.println(result);
    }

}
