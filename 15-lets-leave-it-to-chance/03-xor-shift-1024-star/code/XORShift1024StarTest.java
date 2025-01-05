import org.junit.Test;

public class XORShift1024StarTest {

    @Test
    public void test() {
        long[] seeds = {1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L, 13L, 14L, 15L, 16L};
        XORShift1024Star generator = new XORShift1024Star(seeds);

        for (int i = 0; i < 10; i++) {
            System.out.println(generator.xorShift1024Star());
        }
    }
}
