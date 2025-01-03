import org.junit.Test;

public class OptimizedStringHashTest {

    @Test
    public void test() {
        String s = "hello";
        int b = 26;
        int m = 101;
        int h = OptimizedStringHash.optimizedStringHash(s, b, m);
        System.out.println("Оптимизированное хеш-значение для строки \"" + s + "\" при основании " + b + " и размере таблицы " + m + ": " + h);
    }
}

