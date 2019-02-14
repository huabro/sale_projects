
import com.tianyu.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by sh.mao on 2019/1/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestTransaction {
    @Resource
    UserService userService;
    @Test
    public void testInsert() {
        String loginName="ddd";
        String passward="aaa";
        String email="qqq@163.com";
        userService.register(loginName,passward,email);
    }
}
