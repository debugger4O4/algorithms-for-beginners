import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindMostCommon {

    // Алгоритм
    public static String findMostCommon(List<Map<String, String>> examples, String targetAttribute) {
        if (examples == null || examples.isEmpty()) {
            throw new IllegalArgumentException("Список примеров не может быть пустым.");
        }

        Map<String, Integer> counts = new HashMap<>();
        String mostCommon = null;
        int maxCount = 0;

        for (Map<String, String> example : examples) {
            String value = example.get(targetAttribute);
            int count = counts.getOrDefault(value, 0) + 1;
            counts.put(value, count);

            if (count >= maxCount) {
                maxCount = count;
                mostCommon = value;
            }
        }

        return mostCommon;
    }
}