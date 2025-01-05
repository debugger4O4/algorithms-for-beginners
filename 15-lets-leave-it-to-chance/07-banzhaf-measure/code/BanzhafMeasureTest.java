import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BanzhafMeasureTest {

    @Test
    public void test() {
        BanzhafMeasure.Voter v = new BanzhafMeasure.Voter("Alice", 20);
        List<BanzhafMeasure.Voter> others = Arrays.asList(
                new BanzhafMeasure.Voter("Bob", 10),
                new BanzhafMeasure.Voter("Charlie", 15),
                new BanzhafMeasure.Voter("David", 12),
                new BanzhafMeasure.Voter("Emily", 18));
        BanzhafMeasure.Voter[] allVoters = {
                v,
                new BanzhafMeasure.Voter("Bob", 10),
                new BanzhafMeasure.Voter("Charlie", 15),
                new BanzhafMeasure.Voter("David", 12),
                new BanzhafMeasure.Voter("Emily", 18)
        };
        int quota = 40;
        int numTries = 100000;

        double measure = BanzhafMeasure.banzhafMeasure(v, others, quota, allVoters, numTries);
        System.out.printf("Мера Банцафа для избирателя %s: %.4f\n", v.getName(), measure);
    }
}
