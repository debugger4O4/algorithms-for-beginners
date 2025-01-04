import java.util.List;
import java.util.Map;
import java.util.Set;

public class BestClassifier {

    // Алгоритм
    public static String bestClassifier(List<Map<String, String>> examples, Set<String> attributes, String targetAttribute) {
        if (examples == null || examples.isEmpty()) {
            throw new IllegalArgumentException("Список примеров не может быть пустым.");
        }

        double maximumGain = 0.0;
        String bestClassifier = null;

        for (String attribute : attributes) {
            double gain = CalcInfoGain.calcInfoGain(examples, attribute, targetAttribute);
            if (gain > maximumGain) {
                maximumGain = gain;
                bestClassifier = attribute;
            }
        }

        return bestClassifier;
    }
}