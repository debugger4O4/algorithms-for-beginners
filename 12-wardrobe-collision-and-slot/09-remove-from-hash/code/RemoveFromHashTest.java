import org.junit.Test;

public class RemoveFromHashTest {

    @Test
    public void test() {
        RemoveFromHash.HashTable hashTable = new RemoveFromHash.HashTable(10);
        RemoveFromHash.Record record1 = new RemoveFromHash.Record("key1", "data1");
        RemoveFromHash.Record record2 = new RemoveFromHash.Record("key2", "data2");

        hashTable.insert(record1);
        hashTable.insert(record2);

        RemoveFromHash.Record removedRecord = RemoveFromHash.removeFromHash(hashTable, record1);
        if (removedRecord != null) {
            System.out.println("Запись удалена: ключ = " + removedRecord.key + ", данные = " + removedRecord.data);
        } else {
            System.out.println("Запись не найдена.");
        }
    }
}
