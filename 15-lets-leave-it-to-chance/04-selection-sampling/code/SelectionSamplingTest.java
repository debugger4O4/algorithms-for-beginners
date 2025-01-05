import org.junit.Test;

public class SelectionSamplingTest {

    @Test
    public void test() {
        int[] population = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int m = 5;

        int[] sample = SelectionSampling.selectionSampling(population, m);

        System.out.print("Рандомизированная выборка: ");
        for (int item : sample) {
            System.out.print(item + " ");
        }
    }
}
