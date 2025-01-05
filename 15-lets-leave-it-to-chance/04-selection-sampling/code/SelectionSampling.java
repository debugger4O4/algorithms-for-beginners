import java.util.Random;

public class SelectionSampling {

    // Алгоритм
    public static int[] selectionSampling(int[] population, int m) {
        if (population == null || population.length == 0 || m <= 0 || m > population.length) {
            throw new IllegalArgumentException("Неверные входные параметры.");
        }

        int[] sample = new int[m];
        int k = 0;
        int t = 0;
        int n = population.length;

        Random random = new Random();

        while (k < m) {
            double u = random.nextDouble();
            if (u * (n - t) < (m - k)) {
                sample[k++] = population[t++];
            } else {
                t++;
            }
        }

        return sample;
    }
}
