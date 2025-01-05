public class FactorTwo {

    // Алгоритм
    public static int[] factorTwo(int n) {
        if (n % 2 == 0) {
            int r = 0;
            int q = n;

            while (q % 2 == 0) {
                r++;
                q /= 2;
            }

            return new int[]{r, q};
        } else {
            return null;
        }
    }
}
