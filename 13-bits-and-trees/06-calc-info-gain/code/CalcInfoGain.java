import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalcInfoGain {

    // Алгоритм
    public static double calcInfoGain(List<Map<String, String>> examples, String testAttribute, String targetAttribute) {
        if (examples == null || examples.isEmpty()) {
            throw new IllegalArgumentException("Список примеров не может быть пустым.");
        }

        Map<String, List<Map<String, String>>> groups = new HashMap<>();
        List<String> values = new ArrayList<>();

        for (Map<String, String> example : examples) {
            String value = example.get(testAttribute);
            List<Map<String, String>> group = groups.get(value);
            if (group == null) {
                group = new ArrayList<>();
                groups.put(value, group);
                values.add(value);
            }
            group.add(example);
        }

        double initialEntropy = CalcEntropy.calcEntropy(examples, targetAttribute);
        double infoGain = initialEntropy;

        for (String value : values) {
            List<Map<String, String>> group = groups.get(value);
            double proportion = (double) group.size() / examples.size();
            double entropy = CalcEntropy.calcEntropy(group, targetAttribute);
            infoGain -= proportion * entropy;
        }

        return infoGain;
    }
}