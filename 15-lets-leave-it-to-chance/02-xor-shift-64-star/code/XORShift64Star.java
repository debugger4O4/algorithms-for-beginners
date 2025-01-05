import java.util.Random;

public class XORShift64Star {

    private long state;

    public XORShift64Star(long seed) {
        Random random = new Random();
        if (seed == 0L) {
            seed = random.nextLong(); // Чтобы избежать нулевого состояния
        }
        this.state = seed;
    }

    // Алгоритм
    public long xorShift64Star() {
        long x = state;
        x ^= (x << 12);
        x ^= (x >> 25);
        x ^= (x << 27);
        long result = x * 2685821657736338717L;
        state = x;
        return result;
    }
}
