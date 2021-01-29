import com.shantom.pojo.Books;
import com.shantom.service.BookService;
import com.shantom.service.BookServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = context.getBean("bookServiceImpl", BookServiceImpl.class);
        List<Books> books = bookService.queryAllBooks();
        books.forEach(System.out::println);
    }
}
