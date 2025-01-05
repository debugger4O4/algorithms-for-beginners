import java.util.Random;

public class ReservoirSampling {

    // Алгоритм
    public static <T> T[] reservoirSampling(Iterable<T> scr, int m) {
        if (scr == null || m <= 0) {
            throw new IllegalArgumentException("Неверные входные параметры.");
        }

        @SuppressWarnings("unchecked")
        T[] sample = (T[]) new Object[m];
        int t = 0;

        for (T item : scr) {
            t++;
            if (t <= m) {
                sample[t - 1] = item;
            } else {
                int u = new Random().nextInt(t) + 1;
                if (u <= m) {
                    sample[u - 1] = item;
                }
            }
            if (t > m && !scr.iterator().hasNext()) {
                break;
            }
        }

        return sample;
    }
}
