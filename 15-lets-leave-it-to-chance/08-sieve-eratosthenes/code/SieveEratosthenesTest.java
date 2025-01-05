import org.junit.Test;

public class SieveEratosthenesTest {

    @Test
    public void test() {
        int n = 50;
        boolean[] isPrime = SieveEratosthenes.sieveEratosthenes(n);

        System.out.println("Простые числа до " + n + ":");
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
