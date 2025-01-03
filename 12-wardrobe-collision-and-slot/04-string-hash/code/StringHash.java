public class StringHash {

    // Алгоритм
    public static int stringHash(String s, int b, int m) {
        long v = 0; // Шаг 1
        int n = s.length(); // Шаг 2

        for (int i = 0; i < n; i++) { // Шаг 3
            v += ordinal(s.charAt(i)) * Math.pow(b, n - 1 - i);
        }

        int h = (int)(v % m); // Шаг 5
        return h; // Шаг 6
    }

    private static int ordinal(char c) {
        return Character.toLowerCase(c) - 'a';
    }

}

