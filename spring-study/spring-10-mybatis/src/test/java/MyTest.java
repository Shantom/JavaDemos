import com.shantom.mapper.UserMapper;
import com.shantom.mapper.UserMapperImpl;
import com.shantom.pojo.User;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

public class MyTest {

    @Test
    public void test1() throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SqlSessionTemplate sqlSession = context.getBean("sqlSession", SqlSessionTemplate.class);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getUsers();
        users.forEach(System.out::println);
    }

    @Test
    public void test2() throws Exception {
        // 需要<mybatis:scan>
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        FactoryBean<UserMapper> userMapperFactory = context.getBean("userMapperFactory", FactoryBean.class);
        UserMapper userMapper = userMapperFactory.getObject();
        List<User> users = userMapper.getUsers();
        users.forEach(System.out::println);
    }

    @Test
    public void testTransaction(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper mapper = context.getBean("userMapper", UserMapper.class);

        List<User> users = mapper.getUsers();
        users.forEach(System.out::println);
    }
}
