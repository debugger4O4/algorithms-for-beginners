import org.junit.Test;

public class XORShift64StarTest {

    @Test
    public void test() {
        XORShift64Star generator = new XORShift64Star(1L);
        for (int i = 0; i < 10; i++) {
            System.out.println(generator.xorShift64Star());
        }
    }
}
