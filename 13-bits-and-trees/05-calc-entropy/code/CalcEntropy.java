import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CalcEntropy {

    private static final Logger logger = Logger.getLogger(CalcEntropy.class.getName());

    // Алгоритм
    public static double calcEntropy(List<Map<String, String>> examples, String targetAttribute) {
        if (examples == null || examples.isEmpty()) {
            throw new IllegalArgumentException("Список примеров не может быть пустым.");
        }

        Map<String, Integer> counts = new HashMap<>();
        List<String> values = new ArrayList<>();

        for (Map<String, String> example : examples) {
            String value = example.get(targetAttribute);
            int count = counts.getOrDefault(value, 0) + 1;
            counts.put(value, count);
            if (!values.contains(value)) {
                values.add(value);
            }
        }

        double entropy = 0.0;
        int totalExamples = examples.size();

        for (String value : values) {
            double probability = (double) counts.get(value) / totalExamples;
            try {
                entropy -= probability * log2(probability);
            } catch (ArithmeticException e) {
                logger.log(Level.WARNING, "Попытка взять логарифм нуля. Вероятность равна нулю.", e);
            }
        }

        return entropy;
    }

    private static double log2(double x) {
        return Math.log(x) / Math.log(2);
    }
}