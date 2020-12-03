import jdk.nashorn.internal.scripts.JD;
import org.junit.Test;

import java.sql.*;

public class MyTest {
    @Test
    public void test01(){
        MyDao myDao = new MyDao(1);
        myDao.orm(2);
    }

    /**
     * test为守护线程，不会等待子线程结束，需要使用main方法来实现
     */
    @Test
    public void test02(){
        final JDBCPool pool = new JDBCPool();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                MyDao dao = pool.getDao();
                dao.simpleQuery();
                pool.returnDao(dao);
            });
            System.out.println("thread:" + thread.getName());
            thread.start();
        }
    }

    public static void main(String[] args) {
        final JDBCPool pool = new JDBCPool();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                MyDao dao = pool.getDao();
                dao.simpleQuery();
                pool.returnDao(dao);
            });
            System.out.println("thread:" + thread.getName());
            thread.start();
        }
    }

}
