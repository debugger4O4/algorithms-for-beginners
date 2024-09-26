import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModularInverseTest {

    @Test
    void test() {
        assertEquals(4, ModularInverse.modularInverse(3, 11));
    }
}
