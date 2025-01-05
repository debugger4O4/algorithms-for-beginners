import org.junit.Test;

import java.util.Queue;

public class BruteForceStringSearchTest {

    @Test
    public void test() {
        String p = "abc";
        String t = "abc";
        Queue<Integer> q = BruteForceStringSearch.bruteForceStringSearch(p, t);
        System.out.println("Результатом поиска является: " + q);
    }
}
