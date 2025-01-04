import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FilterExamples {

    // Алгоритм
    public static List<Map<String, String>> filterExamples(List<Map<String, String>> examples, String attribute, String value) {
        if (examples == null) {
            throw new IllegalArgumentException("Список примеров не может быть пустым.");
        }

        List<Map<String, String>> filtered = new ArrayList<>();

        for (Map<String, String> example : examples) {
            if (value.equals(example.get(attribute))) {
                filtered.add(example);
            }
        }

        return filtered;
    }
}