import com.chapter_1.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MyTest {

    @Autowired
    private UserService userService;

    @Test
    public void test1(){
        System.out.println("test1");
        userService.deleteUser();
        userService.updateUser();
    }

}
