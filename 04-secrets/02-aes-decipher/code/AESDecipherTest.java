import org.junit.jupiter.api.Test;

public class AESDecipherTest {
    @Test
    void test() {
        byte[] b = "Привет".getBytes();
        KeyDecipher k = new KeyDecipher();
        int n = 10;
        System.out.println(AESDecipher.aesDecipher(b, k, n));
    }
}
