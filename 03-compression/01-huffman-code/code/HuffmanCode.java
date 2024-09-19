import java.util.ArrayList;
import java.util.Collections;

public class HuffmanCode {

    public HuffmanCode() {}

    public static HuffmanCodeTreeNode createHuffmanCode(ArrayList<HuffmanCodeTreeNode> pq) {
        while (pq.size() > 1) {
            Collections.sort(pq);
            HuffmanCodeTreeNode x = pq.remove(pq.size() - 1);
            HuffmanCodeTreeNode y = pq.remove(pq.size() - 1);
            int sum =  y.weight + x.weight;
            HuffmanCodeTreeNode z = new HuffmanCodeTreeNode(null, sum, x, y);
            pq.add(z);
        }
        return pq.get(0);
    }

    // Класс для представления кодового дерева
    static class HuffmanCodeTreeNode implements Comparable<HuffmanCodeTreeNode> {

        Character content;
        int weight;
        HuffmanCodeTreeNode left;
        HuffmanCodeTreeNode right;

        public HuffmanCodeTreeNode(Character content, int weight) {
            this.content = content;
            this.weight = weight;
        }

        public HuffmanCodeTreeNode(Character content, int weight, HuffmanCodeTreeNode left, HuffmanCodeTreeNode right) {
            this.content = content;
            this.weight = weight;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(HuffmanCodeTreeNode o) {
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