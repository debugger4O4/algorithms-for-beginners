import org.junit.jupiter.api.Test;

public class AESCipherTest {

    @Test
    void test() {
        byte[] b = new byte[16];
        String k = "SECRET_KEY";
        String n = "AES cipher test";
        AESCipher.aesCipher(b, k, n);
    }
}
