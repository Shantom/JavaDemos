import com.shantom.service.FruitMarket;
import com.shantom.service.IFruitMarket;

public class MyTest {
    public static void main(String[] args) {
        IFruitMarket fruitMarket = new FruitMarket();
        System.out.println("I got one " + fruitMarket.getOneFruit());
    }
}
