import com.shantom.pojo.User;
import com.shantom.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {

    @Test
    public void test1(){
        ApplicationContext context = new AnnotationConfigApplicationContext(UserService.class);
        User user = context.getBean("user", User.class);
        System.out.println(user.toString());
    }
}
