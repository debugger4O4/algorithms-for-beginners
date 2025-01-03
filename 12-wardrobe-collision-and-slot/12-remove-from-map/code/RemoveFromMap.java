import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map.Entry;


public class RemoveFromMap {

    // Алгоритм
    public static Entry<String, Integer> removeFromMap(HashMap<String, Integer> map, String key) {
        if (!map.containsKey(key)) {
            return null;
        }

        int value = map.remove(key);
        return new AbstractMap.SimpleEntry<>(key, value);
    }
}
