import org.junit.Test;

public class InsertInHashTest {

    @Test
    public void test() {
        InsertInHash.HashTable hashTable = new InsertInHash.HashTable(10);
        InsertInHash.Record record1 = new InsertInHash.Record("key1", "data1");
        InsertInHash.Record record2 = new InsertInHash.Record("key2", "data2");

        InsertInHash.insertInHash(hashTable, record1);
        InsertInHash.insertInHash(hashTable, record2);

        InsertInHash.Record foundRecord = hashTable.find("key1");
        if (foundRecord != null) {
            System.out.println("Запись найдена: ключ = " + foundRecord.key + ", данные = " + foundRecord.data);
        } else {
            System.out.println("Запись не найдена.");
        }
    }
}
