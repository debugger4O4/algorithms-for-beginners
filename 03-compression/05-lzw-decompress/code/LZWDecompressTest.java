import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LZWDecompressTest {
    @Test
    void test() {
        int[] compressed = new int[]{77, 69, 76, 76, 79, 87, 32, 89, 129, 131, 133, 70, 136, 132};
        int nb = 8; // число битов для предоставления элемента
        int n = 256; // число элеметнов в алфавите
        assertEquals(
                "MELLOW YELLOW FELLOW", LZWDecompress.lzwDecompress(compressed, nb, n)
        );
    }
}
