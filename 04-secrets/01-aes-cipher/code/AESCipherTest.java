import org.junit.jupiter.api.Test;

public class AESCipherTest {

    @Test
    void test() {
        byte[] b = "Привет".getBytes();
        Key k = new Key();
        int n = 10;
        System.out.println(AESCipher.aesCipher(b, k, n));
    }
}
