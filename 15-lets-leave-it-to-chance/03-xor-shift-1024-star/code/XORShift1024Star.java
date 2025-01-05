import java.util.Arrays;
import java.util.Random;

public class XORShift1024Star {


    private final long[] state;
    private int p;

    public XORShift1024Star(long... seeds) {
        if (seeds.length != 16) {
            throw new IllegalArgumentException("Количество семян должно быть равно 16.");
        }
        state = Arrays.copyOf(seeds, 16);
        p = 0;
    }

    public XORShift1024Star() {
        Random random = new Random();
        state = new long[16];
        for (int i = 0; i < 16; i++) {
            state[i] = random.nextLong();
        }
        p = 0;
    }

    // Алгоритм
    public long xorShift1024Star() {
        long s0 = state[p];
        p = (p + 1) & 15;
        long s1 = state[p];
        s1 ^= (s1 << 31);
        s1 ^= (s1 >>> 11);
        s0 ^= (s0 >>> 30);
        state[p] = s0 ^ s1;
        return state[p] * 1181783497276652981L;
    }
}
