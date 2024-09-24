import org.junit.jupiter.api.Test;

public class AESCipherTest {

    @Test
    void test() {
        short[] b = new short[]{
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
        };
        Key k = new Key();
        int n = 10;
        System.out.println(AESCipher.aesCipher(b, k, n));
    }
}
