import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModExpRepeatedSquaringTest {

    @Test
    void test() {
        int g = 123;
        int x = 4;
        int p = 7;
        assertEquals(4, ModExpRepeatedSquaring.modExpRepeatedSquaring(g, x, p));
    }
}
