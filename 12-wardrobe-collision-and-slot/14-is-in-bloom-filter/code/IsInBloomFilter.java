import java.util.BitSet;
import java.util.Random;

public class IsInBloomFilter {

    private final BitSet bitset;
    private final int size;
    private final int numHashes;
    private final Random random;

    public IsInBloomFilter(int size, int numHashes) {
        this.size = size;
        this.numHashes = numHashes;
        this.bitset = new BitSet(size);
        this.random = new Random();
    }

    // Алгоритм
    public boolean isInBloomFilter(String item) {
        for (int i = 0; i < numHashes; i++) {
            int hash = getHash(item, i);
            if (!bitset.get(hash % size)) {
                return false;
            }
        }
        return true;
    }

    public void add(String item) {
        for (int i = 0; i < numHashes; i++) {
            int hash = getHash(item, i);
            bitset.set(hash % size);
        }
    }


    private int getHash(String item, int seed) {
        int hash = item.hashCode();
        hash ^= random.nextInt() * seed;
        return Math.abs(hash);
    }
}
