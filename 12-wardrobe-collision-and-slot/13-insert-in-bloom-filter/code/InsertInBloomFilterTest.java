import org.junit.Test;

public class InsertInBloomFilterTest {

    @Test
    public void test() {
        InsertInBloomFilter bloomFilter = new InsertInBloomFilter(10000, 3);

        bloomFilter.add("hello");
        bloomFilter.add("world");

        System.out.println(bloomFilter.mightContain("hello")); // true
        System.out.println(bloomFilter.mightContain("world")); // true
        System.out.println(bloomFilter.mightContain("test"));  // false (вероятно)
    }
}
