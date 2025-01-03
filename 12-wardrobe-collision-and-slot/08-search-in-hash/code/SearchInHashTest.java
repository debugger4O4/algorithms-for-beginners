import org.junit.Test;

public class SearchInHashTest {

    @Test
    public void test() {
        SearchInHash.HashTable hashTable = new SearchInHash.HashTable(10);
        SearchInHash.Record record1 = new SearchInHash.Record("key1", "data1");
        SearchInHash.Record record2 = new SearchInHash.Record("key2", "data2");

        hashTable.insert(record1);
        hashTable.insert(record2);

        SearchInHash.Record queryRecord = new SearchInHash.Record("key1", null);
        boolean found = SearchInHash.searchInHash(hashTable, queryRecord);
        if (found) {
            System.out.println("Запись найдена.");
        } else {
            System.out.println("Запись не найдена.");
        }
    }
}
