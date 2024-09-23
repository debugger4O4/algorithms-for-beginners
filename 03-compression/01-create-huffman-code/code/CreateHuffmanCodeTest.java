import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateHuffmanCodeTest {
    Map<Character, String> codes;
    StringBuilder encoded;

    @Test
    void test() {
        initTest("effervescence");
        assertEquals("{c=101, e=0, f=100, n=1101, r=1100, s=1111, v=1110}", codes.toString());
        assertEquals("010010001100111001111101011011010", encoded.toString());
    }

    public void initTest(String message) {
        // Дерево для подсчета частоты каждого символа
        Map<Character, Integer> frequencies = countFrequency(message);

        // Создание спсика листов дерева
        List<CreateHuffmanCode.HuffmanCodeBinaryTree> pq = new ArrayList<>();
        for (Character c : frequencies.keySet()) {
            pq.add(new CreateHuffmanCode.HuffmanCodeBinaryTree(c, frequencies.get(c)));
        }

        // Построение кодового дерева с помощью алгоритма Хаффмана
        CreateHuffmanCode.HuffmanCodeBinaryTree huffmanCode = CreateHuffmanCode.createHuffmanCode(pq);

        // Генерация таблицы префиксных кодов для кодируемых символов с помощью кодового дерева
        codes = new TreeMap<>();
        for (Character c : frequencies.keySet()) {
            codes.put(c, huffmanCode.getCodeForCharacter(c, ""));
        }

        // Кодировка текста. Замена сивола соответствующим кодом
        encoded = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            encoded.append(codes.get(message.charAt(i)));
        }
    }

    public Map<Character, Integer> countFrequency(String message) {
        Map<Character, Integer> freqMap = new TreeMap<>();
        for (int i = 0; i < message.length(); i++) {
            Character c = message.charAt(i);
            Integer count = freqMap.get(c);
            freqMap.put(c, count != null ? count + 1 : 1);
        }
        return freqMap;
    }
}
