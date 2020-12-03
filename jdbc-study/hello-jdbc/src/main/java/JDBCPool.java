import java.util.ArrayList;
import java.util.List;

public class JDBCPool {
    private final List<MyDao> pool = new ArrayList<>();

    public JDBCPool() {
        for (int i = 0; i < 3; i++) {
            pool.add(new MyDao(i));
        }
    }

    public synchronized MyDao getDao(){
        while(pool.isEmpty()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return pool.remove(0);
    }

    public synchronized void returnDao(MyDao myDao){
        pool.add(myDao);
        System.out.println("dao id "+myDao.id+ "returned");
        this.notifyAll();
    }
}
