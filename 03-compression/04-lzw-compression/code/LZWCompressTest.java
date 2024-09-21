import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LZWCompressTest {

    @Test
    void test() {
        String s = "MELLOW YELLOW FELLOW";
        int nb = 8; // число битов для предоставления элемента
        int n = 256; // число элеметнов в алфавите
        assertEquals(
                "[77, 69, 76, 76, 79, 87, 32, 89, 129, 131, 133, 70, 136, 132]", LZWCompress.lzwCompress(s, nb, n).toString()
        );
    }
}
