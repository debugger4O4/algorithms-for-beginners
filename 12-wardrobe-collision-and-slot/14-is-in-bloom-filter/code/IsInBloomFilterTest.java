import org.junit.Test;

public class IsInBloomFilterTest {

    @Test
    public void test() {
        IsInBloomFilter bloomFilter = new IsInBloomFilter(10000, 3);

        bloomFilter.add("hello");
        bloomFilter.add("world");

        System.out.println(bloomFilter.isInBloomFilter("hello")); // true
        System.out.println(bloomFilter.isInBloomFilter("world")); // true
        System.out.println(bloomFilter.isInBloomFilter("test"));  // false (вероятно)
    }
}
