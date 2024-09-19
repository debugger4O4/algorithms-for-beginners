import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HuffmanCodeTest {

    @Test
    void test() {
        String message = "effervescence";

        // Дерево для подсчета частоты каждого символа
        TreeMap<Character, Integer> frequencies = HuffmanCode.countFrequency(message);

        // Создание спсика листов дерева
        ArrayList<HuffmanCode.CodeTreeNode> pq = new ArrayList<>();
        for (Character c : frequencies.keySet()) {
            pq.add(new HuffmanCode.CodeTreeNode(c, frequencies.get(c)));
        }

        // Построение кодового дерева с помощью алгоритма Хаффмана
        HuffmanCode.CodeTreeNode huffmanCode = HuffmanCode.createHuffmanCode(pq);

        // Генерация таблицы префиксных кодов для кодируемых символов с помощью кодового дерева
        TreeMap<Character, String> codes = new TreeMap<>();
        for (Character c : frequencies.keySet()) {
            codes.put(c, huffmanCode.getCodeForCharacter(c, ""));
        }

        // Кодировка текста. Замена сивола соответствующим кодом
        StringBuilder encoded = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            encoded.append(codes.get(message.charAt(i)));
        }

        assertEquals("{c=101, e=0, f=100, n=1101, r=1100, s=1111, v=1110}", codes.toString());
        assertEquals("010010001100111001111101011011010", encoded.toString());
    }
}
