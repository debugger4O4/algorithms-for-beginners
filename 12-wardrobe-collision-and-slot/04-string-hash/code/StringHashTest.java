import org.junit.Test;

public class StringHashTest {

    @Test
    public void test() {
        String s = "hello";
        int b = 26;
        int m = 101;
        int h = StringHash.stringHash(s, b, m);
        System.out.println("Хеш-значение для строки \"" + s + "\" при основании " + b + " и размере таблицы " + m + ": " + h);
    }
}
