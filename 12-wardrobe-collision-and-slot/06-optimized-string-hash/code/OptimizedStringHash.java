public class OptimizedStringHash {

    // Алгоритм
    public static int optimizedStringHash(String s, int b, int m) {
        int h = 0;

        for (char c : s.toCharArray()) {
            h = (b * h + ordinal(c)) % m;
        }

        return h;
    }

    private static int ordinal(char c) {
        return Character.toLowerCase(c) - 'a';
    }
}
