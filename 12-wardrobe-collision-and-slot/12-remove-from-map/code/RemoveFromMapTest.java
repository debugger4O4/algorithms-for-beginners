import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class RemoveFromMapTest {

    @Test
    public void test() {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("apple", 10);
        map.put("banana", 20);
        map.put("cherry", 30);

        System.out.println("Исходная карта: " + map);

        Map.Entry<String, Integer> result = RemoveFromMap.removeFromMap(map, "banana");

        if (result != null) {
            System.out.println("Удаленная пара: [" + result.getKey() + ", " + result.getValue() + "]");
        } else {
            System.out.println("Элемент не найден.");
        }

        System.out.println("Карта после удаления: " + map);
    }
}
