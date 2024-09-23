import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Сжатие Лемпеля — Зива — Велча.
 */
public class LZWCompress {

    // Алгоритм
    public static List<Integer> lzwCompress(String s, int nb, int n) {
        List<Integer> compressed = new ArrayList<>();
        int maxCode = (int) Math.pow(2, nb) - 1; // Возможные значения кодирования
        Map<String, Integer> t = new HashMap<>();
        for (int i = 0; i < n; i++) {
            t.put((char) i + "", i);
        }
        /*
            code - Начальное число для предосталение групп из двух или более букв. 0-127 - для предоставления униграмм,
            128-255 - для продоставления n-грамм > 1
         */
        int code = n / 2;
        String w = "";
        int p;
        for (char c : s.toCharArray()) {
            String wc = w + c;
            Integer v = t.getOrDefault(wc, null);
            if (v != null) {
                w = wc;
            } else {
                v = t.get(w);
                p = compressed.size();
                compressed.add(p, v);
                w = c + "";
                // Cохраняем удлиненную n-грамму wc. Это случится, если мы не исчерпали все возможные кодирования
                if (code <= maxCode) {
                    t.put(wc, code);
                    code += 1;
                }
            }
        }
        if (w.length() > 0) {
            compressed.add(t.get(w));
        }
        return compressed;
    }
}