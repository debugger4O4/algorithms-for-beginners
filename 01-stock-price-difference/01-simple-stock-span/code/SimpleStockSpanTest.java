import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleStockSpanTest {
    @Test
    void test() {
        int[] quotes = {7, 10, 8, 6, 3, 8, 9};
        int[] answer = {1, 2, 1, 1, 1 ,4 ,5};
        assertTrue(
                answer.length == SimpleStockSpan.simpleStockSpan(quotes).length
                && Arrays.equals(answer, SimpleStockSpan.simpleStockSpan(quotes))
        );
    }
}