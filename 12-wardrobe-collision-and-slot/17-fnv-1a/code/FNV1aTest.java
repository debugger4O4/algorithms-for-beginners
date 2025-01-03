import org.junit.Test;

public class FNV1aTest {

    @Test
    public void test() {
        String inputString = "example";
        int initialValue = 12345;

        int hashValue = FNV1a.fnv1a(inputString, initialValue);
        System.out.println("Хеш-значение строки '" + inputString + "' с начальным значением " + initialValue + ": " + hashValue);
    }
}
