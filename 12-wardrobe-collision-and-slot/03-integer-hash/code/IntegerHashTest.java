import org.junit.Test;

public class IntegerHashTest {

    @Test
    public void test() {
        int k = 12345;
        int m = 100;
        int h = IntegerHash.integerHash(k, m);
        System.out.println("Хеш-значение для числа " + k + " при размере таблицы " + m + ": " + h);
    }
}
