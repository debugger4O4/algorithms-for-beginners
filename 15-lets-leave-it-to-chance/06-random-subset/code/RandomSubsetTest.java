import org.junit.Test;

import java.util.List;

public class RandomSubsetTest {

    @Test
    public void test() {
        List<Integer> inputSet = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> randomSubset = RandomSubset.randomSubset(inputSet);

        System.out.println("Исходное множество: " + inputSet);
        System.out.println("Случайное подмножество: " + randomSubset);
    }
}
