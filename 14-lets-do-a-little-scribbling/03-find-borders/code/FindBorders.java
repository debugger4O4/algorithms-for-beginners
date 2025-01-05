public class FindBorders {

    // Алгоритм
    public static int[] findBorders(String p) {
        int m = p.length();
        int[] b = new int[m + 1];
        int k = 0;
        while (k < m) {

            if (p.toCharArray()[k] == ' ') {
                k++;
                b[k] = k;
            } else if (p.toCharArray()[k] == '\n') {
                k--;
                b[k] = k;
            }
        }
        for (int i = 1; i < m; i++) {
            if (p.toCharArray()[i] == ' ') {
                b[i] = b[i] + 1;
            } else if (p.toCharArray()[i] == '\n') {
                b[i] = b[i] - 1;
            }
        }
        return b;
    }
}