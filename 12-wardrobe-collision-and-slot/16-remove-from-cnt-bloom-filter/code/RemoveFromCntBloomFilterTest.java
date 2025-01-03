import org.junit.Test;

public class RemoveFromCntBloomFilterTest {

    @Test
    public void test() {
        RemoveFromCntBloomFilter cbFilter = new RemoveFromCntBloomFilter(10000, 3);

        cbFilter.insert("hello");
        cbFilter.insert("world");

        System.out.println(cbFilter.mightContain("hello")); // true
        System.out.println(cbFilter.mightContain("world")); // true

        cbFilter.remove("hello");
        System.out.println(cbFilter.mightContain("hello")); // false

    }
}
