import java.util.Collections;
import java.util.List;

public class CreateHuffmanCode {

    public CreateHuffmanCode() {
    }

    // Алгоритм
    public static HuffmanCodeBinaryTree createHuffmanCode(List<HuffmanCodeBinaryTree> pq) {
        while (pq.size() > 1) {
            Collections.sort(pq);
            HuffmanCodeBinaryTree x = pq.remove(pq.size() - 1);
            HuffmanCodeBinaryTree y = pq.remove(pq.size() - 1);
            int sum = y.weight + x.weight;
            HuffmanCodeBinaryTree z = new HuffmanCodeBinaryTree(null, sum, x, y);
            pq.add(z);
        }
        return pq.get(0);
    }

    // Класс для представления кодового дерева
    static class HuffmanCodeBinaryTree implements Comparable<HuffmanCodeBinaryTree> {

        Character content;
        int weight;
        HuffmanCodeBinaryTree left;
        HuffmanCodeBinaryTree right;

        public HuffmanCodeBinaryTree(Character content, int weight) {
            this.content = content;
            this.weight = weight;
        }

        public HuffmanCodeBinaryTree(Character content, int weight, HuffmanCodeBinaryTree left, HuffmanCodeBinaryTree right) {
            this.content = content;
            this.weight = weight;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(HuffmanCodeBinaryTree o) {
            return o.weight - weight;
        }

        // Извлечение кода для символа
        public String getCodeForCharacter(Character ch, String parentPath) {
            if (content == ch) {
                return parentPath;
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