public class FNV1a {
    private static final int OFFSET_BASIS_32 = 0x811C9DC5;
    private static final int PRIME_32 = 0x01000193;

    // Алгоритм
    public static int fnv1a(String str, int initialValue) {
        int hash = OFFSET_BASIS_32 ^ initialValue;
        char[] chars = str.toCharArray();

        for (char c : chars) {
            hash ^= c;
            hash *= PRIME_32;
            hash &= 0xFFFFFFFF; // Ограничиваем результат до 32 бит
        }

        return hash;
    }
}
