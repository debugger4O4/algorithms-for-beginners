import org.junit.Test;

import java.util.Iterator;

public class ReservoirSamplingTest {

    @Test
    public void test() {
        String[] population = {"A", "B", "C", "D", "E", "F", "G", "H"};
        int m = 5;

        String[] sample = ReservoirSampling.reservoirSampling(new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                return new Iterator<>() {
                    private int index = 0;

                    @Override
                    public boolean hasNext() {
                        return index < population.length;
                    }

                    @Override
                    public String next() {
                        return population[index++];
                    }
                };
            }
        }, m);

        System.out.print("Накопительная выборка: ");
        for (String item : sample) {
            System.out.print(item + " ");
        }
    }
}
