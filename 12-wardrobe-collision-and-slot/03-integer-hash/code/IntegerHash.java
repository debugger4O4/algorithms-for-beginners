public class IntegerHash {

    // Алгоритм
    public static int integerHash(int k, int m) {
        int h = k % m;
        return h;
    }
}
