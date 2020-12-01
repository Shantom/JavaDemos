import com.shantom.demoStatic.UserProxy;
import com.shantom.demoStatic.UserServiceImpl;
import org.junit.Test;

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

    }
}
