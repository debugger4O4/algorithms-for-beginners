import java.util.ArrayList;
import java.util.List;


public class Lookup {

    // Алгоритм
    public static Object lookup(HashTable T, Object k) {
        int h = T.getBucketIndex(k);
        Pair p = T.search(k);

        if (p == null) {
            return null;
        } else {
            return p.value;
        }
    }

    static class Pair {
        Object key;
        Object value;

        public Pair(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Pair)) {
                return false;
            }
            Pair other = (Pair) obj;
            return this.key.equals(other.key);
        }

        @Override
        public int hashCode() {
            return key.hashCode();
        }
    }

    static class HashTable {
        List<Pair>[] buckets;

        public HashTable(int capacity) {
            buckets = new ArrayList[capacity];
            for (int i = 0; i < capacity; i++) {
                buckets[i] = new ArrayList<>();
            }
        }

        public int getBucketIndex(Object key) {
            return Math.abs(key.hashCode() % buckets.length);
        }

        public void insert(Pair pair) {
            int bucketIndex = getBucketIndex(pair.key);
            buckets[bucketIndex].add(pair);
        }

        public Pair search(Object key) {
            int bucketIndex = getBucketIndex(key);
            for (Pair pair : buckets[bucketIndex]) {
                if (pair.key.equals(key)) {
                    return pair;
                }
            }
            return null;
        }
    }
}
