public class InsertInCntBloomFilterTest {

    public static void main(String[] args) {
        InsertInCntBloomFilter cbFilter = new InsertInCntBloomFilter(10000, 3);

        cbFilter.insert("hello");
        cbFilter.insert("world");

        System.out.println(cbFilter.mightContain("hello")); // true
        System.out.println(cbFilter.mightContain("world")); // true
        System.out.println(cbFilter.mightContain("test"));  // false (вероятно)

        cbFilter.delete("hello");
        System.out.println(cbFilter.mightContain("hello")); // false
    }
}
