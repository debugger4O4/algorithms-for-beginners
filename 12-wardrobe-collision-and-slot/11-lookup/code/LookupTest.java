import org.junit.Test;

public class LookupTest {

    @Test
    public void test() {
        Lookup.HashTable hashTable = new Lookup.HashTable(10);
        hashTable.insert(new Lookup.Pair("key1", "value1"));
        hashTable.insert(new Lookup.Pair("key2", "value2"));

        Object value1 = Lookup.lookup(hashTable, "key1");
        Object value2 = Lookup.lookup(hashTable, "key2");
        Object nonExistentValue = Lookup.lookup(hashTable, "nonexistent_key");

        System.out.println("Value for key1: " + value1);
        System.out.println("Value for key2: " + value2);
        System.out.println("Value for nonexistent_key: " + nonExistentValue);
    }
}
