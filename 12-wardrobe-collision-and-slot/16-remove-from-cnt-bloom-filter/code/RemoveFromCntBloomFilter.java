import java.util.Arrays;
import java.util.Random;

public class RemoveFromCntBloomFilter {

    private final int[] counterArray;
    private final int size;
    private final int numHashes;
    private final Random random;

    public RemoveFromCntBloomFilter(int size, int numHashes) {
        this.size = size;
        this.numHashes = numHashes;
        this.counterArray = new int[size];
        Arrays.fill(counterArray, 0);
        this.random = new Random();
    }

    // Алгоритм
    public void remove(String item) {
        for (int i = 0; i < numHashes; i++) {
            int hash = getHash(item, i);
            if (counterArray[hash % size] > 0) {
                counterArray[hash % size]--;
            }
        }
    }

    public void insert(String item) {
        for (int i = 0; i < numHashes; i++) {
            int hash = getHash(item, i);
            counterArray[hash % size]++;
        }
    }

    public boolean mightContain(String item) {
        for (int i = 0; i < numHashes; i++) {
            int hash = getHash(item, i);
            if (counterArray[hash % size] == 0) {
                return false;
            }
        }
        return true;
    }

    private int getHash(String item, int seed) {
        int hash = item.hashCode();
        hash ^= random.nextInt() * seed;
        return Math.abs(hash);
    }
}
