import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpRepeatedSquaringTest {

    @Test
    void test() {
        int g = 2;
        int x = 3;
        assertEquals(8, ExpRepeatedSquaring.expRepeatedSquaring(g, x));
    }
}
