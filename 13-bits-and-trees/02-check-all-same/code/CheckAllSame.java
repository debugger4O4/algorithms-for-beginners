import java.util.List;
import java.util.Map;

public class CheckAllSame {

    // Алгоритм
    public static boolean checkAllSame(List<Map<String, String>> examples, String targetAttribute) {
        if (examples == null || examples.isEmpty()) {
            throw new IllegalArgumentException("Список примеров не может быть пустым.");
        }

        String firstValue = examples.get(0).get(targetAttribute);

        for (int i = 1; i < examples.size(); i++) {
            String currentValue = examples.get(i).get(targetAttribute);
            if (!currentValue.equals(firstValue)) {
                return false;
            }
        }

        return true;
    }
}