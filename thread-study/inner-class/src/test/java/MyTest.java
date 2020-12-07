import com.shantom.Hero;
import org.junit.Test;

public class MyTest {

    @Test
    public void test01(){
        final int damage = 100;
        Hero hero = new Hero() {
            @Override
            public void attack() {
                System.out.println("造成了伤害"+damage);
            }
        };
        hero.attack();
    }
}
