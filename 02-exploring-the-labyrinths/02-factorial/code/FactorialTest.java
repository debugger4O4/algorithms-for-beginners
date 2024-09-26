import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialTest {

    @Test
    void test() {
        assertEquals(120, Factorial.factorial(5));
    }
}
