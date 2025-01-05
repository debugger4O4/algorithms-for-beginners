import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomSubset {

    // Алгоритм
    public static <T> List<T> randomSubset(List<T> inputSet) {
        if (inputSet == null || inputSet.isEmpty()) {
            throw new IllegalArgumentException("Входное множество не должно быть пустым.");
        }

        List<T> randomSubset = new ArrayList<>();
        Random random = new Random();

        for (T element : inputSet) {
            if (random.nextDouble() < 0.5) {
                randomSubset.add(element);
            }
        }

        return randomSubset;
    }
}
