import org.junit.Test;

public class InsertInMapTest {

    @Test
    public void test() {
        InsertInMap.HashTable hashTable = new InsertInMap.HashTable(10);
        InsertInMap.insertInMap(hashTable, "key1", "value1");
        InsertInMap.insertInMap(hashTable, "key2", "value2");
        InsertInMap.insertInMap(hashTable, "key1", "newValue1");

        InsertInMap.Pair p1 = hashTable.search("key1");
        InsertInMap.Pair p2 = hashTable.search("key2");

        if (p1 != null && p2 != null) {
            System.out.println("key1: " + p1.value);
            System.out.println("key2: " + p2.value);
        } else {
            System.out.println("Ошибка: одна или обе записи не найдены.");
        }
    }
}
