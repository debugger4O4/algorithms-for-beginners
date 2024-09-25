import org.junit.jupiter.api.Test;

public class AESCipherTest {

    @Test
    void test() {
        byte[] b = "Привет".getBytes();
        KeyCipher k = new KeyCipher();
        int n = 10;
        System.out.println(AESCipher.aesCipher(b, k, n));
    }
}
