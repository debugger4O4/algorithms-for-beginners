import org.junit.Test;

import java.util.Arrays;

public class FindBordersTest {

    @Test
    public void test() {
        String p = "Hello World!";
        int[] b = FindBorders.findBorders(p);
        System.out.println(Arrays.toString(b));
    }
}
