import java.util.ArrayList;
import java.util.List;

public class InsertInHash {

    // Алгоритм
    public static void insertInHash(HashTable T, Record x) {
        int h = T.getBucketIndex(x.key);
        T.insert(x);
    }


    static class Record {
        Object key;
        Object data;

        public Record(Object key, Object data) {
            this.key = key;
            this.data = data;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Record)) {
                return false;
            }
            Record other = (Record) obj;
            return this.key.equals(other.key);
        }

        @Override
        public int hashCode() {
            return key.hashCode();
        }
    }

    static class HashTable {
        List<Record>[] buckets;

        public HashTable(int capacity) {
            buckets = new ArrayList[capacity];
            for (int i = 0; i < capacity; i++) {
                buckets[i] = new ArrayList<>();
            }
        }

        public int getBucketIndex(Object key) {
            return Math.abs(key.hashCode() % buckets.length);
        }

        public void insert(Record x) {
            int bucketIndex = getBucketIndex(x.key);
            buckets[bucketIndex].add(x);
        }

        public Record find(Object key) {
            int bucketIndex = getBucketIndex(key);
            for (Record record : buckets[bucketIndex]) {
                if (record.key.equals(key)) {
                    return record;
                }
            }
            return null;
        }
    }
}