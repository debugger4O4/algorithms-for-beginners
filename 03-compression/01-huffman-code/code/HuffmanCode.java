import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class HuffmanCode {

    public static HuffmanCode.CodeTreeNode createHuffmanCode(ArrayList<HuffmanCode.CodeTreeNode> pq) {
        while (pq.size() > 1) {
            Collections.sort(pq);
            HuffmanCode.CodeTreeNode x = pq.remove(pq.size() - 1);
            HuffmanCode.CodeTreeNode y = pq.remove(pq.size() - 1);
            int sum =  y.weight + x.weight;
            HuffmanCode.CodeTreeNode z = new HuffmanCode.CodeTreeNode(null, sum, x, y);
            pq.add(z);
        }
        return pq.get(0);
    }

    public static TreeMap<Character, Integer> countFrequency(String text) {
        TreeMap<Character, Integer> freqMap = new TreeMap<>();
        for (int i = 0; i < text.length(); i++) {
            Character c = text.charAt(i);
            Integer count = freqMap.get(c);
            freqMap.put(c, count != null ? count + 1 : 1);
        }
        return freqMap;
    }

    // Класс для представления кодового дерева
    public static class CodeTreeNode implements Comparable<CodeTreeNode> {

        Character content;
        int weight;
        CodeTreeNode left;
        CodeTreeNode right;

        public CodeTreeNode(Character content, int weight) {
            this.content = content;
            this.weight = weight;
        }

        public CodeTreeNode(Character content, int weight, CodeTreeNode left, CodeTreeNode right) {
            this.content = content;
            this.weight = weight;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(CodeTreeNode o) {
            return o.weight - weight;
        }

        // Извлечение кода для символа
        public String getCodeForCharacter(Character ch, String parentPath) {
            if (content == ch) {
                return  parentPath;
            } else {
                if (left != null) {
                    String path = left.getCodeForCharacter(ch, parentPath + 0);
                    if (path != null) {
                        return path;
                    }
                }
                if (right != null) {
                    return right.getCodeForCharacter(ch, parentPath + 1);
                }
            }
            return null;
        }
    }
}