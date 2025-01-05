import java.util.Arrays;

public class SieveEratosthenes {

    // Алгоритм
    public static boolean[] sieveEratosthenes(int n) {
        if (n < 2) {
            throw new IllegalArgumentException("n должно быть больше 1.");
        }

        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int j = p * p; j <= n; j += p) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }
}
