import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExtendedEuclidTest {

    @Test
    void test() {
        assertEquals("[5, 1, -2]", Arrays.toString(ExtendedEuclid.extendedEuclid(35, 15)));
    }
}
