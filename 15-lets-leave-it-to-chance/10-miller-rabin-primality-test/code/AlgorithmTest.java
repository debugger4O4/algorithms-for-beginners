import org.junit.Test;

import java.util.Scanner;

public class AlgorithmTest {

    @Test
    public void test() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Miller Rabin Primality Algorithm Test\n");
        MillerRabinPrimalityTest mr = new MillerRabinPrimalityTest();
        System.out.println("Enter number\n");
        long num = scan.nextLong();
        System.out.println("\nEnter number of iterations");
        int k = scan.nextInt();
        boolean prime = mr.millerRabinPrimalityTest(num, k);
        if (prime)
            System.out.println("\n" + num + " is prime");
        else
            System.out.println("\n" + num + " is composite");

    }
}
