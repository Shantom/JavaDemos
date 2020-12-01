import com.shantom.demoDynamic.UserInvocationHandler;
import com.shantom.demoStatic.UserProxy;
import com.shantom.demoStatic.UserService;
import com.shantom.demoStatic.UserServiceImpl;
import org.junit.Test;

import java.lang.reflect.Proxy;

public class MyTest {

    @Test
    public void testStatic(){
        UserProxy userProxy = new UserProxy();
        userProxy.setUserService(new UserServiceImpl());
        userProxy.add();
        userProxy.delete();
    }

    @Test
    public void testDynamic(){
        //真实角色
        UserService userService = new UserServiceImpl();

        UserInvocationHandler pih = new UserInvocationHandler();
        pih.setTarget(userService);

        UserService proxy = (UserService) pih.getProxy();
        proxy.add();
    }
}
