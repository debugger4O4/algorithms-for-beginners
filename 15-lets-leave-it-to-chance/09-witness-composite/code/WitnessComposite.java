import java.math.BigInteger;
import java.security.SecureRandom;

public class WitnessComposite {

    // Алгоритм
    public static boolean witnessComposite(BigInteger p) {
        if (!p.testBit(0)) {
            throw new IllegalArgumentException("Число должно быть нечетным.");
        }

        BigInteger two = BigInteger.valueOf(2);
        BigInteger one = BigInteger.ONE;
        BigInteger minusOne = p.subtract(one);

        // Разложение p-1 на 2^r * q
        BigInteger q = minusOne;
        int r = 0;
        while (!q.testBit(0)) {
            q = q.shiftRight(1);
            r++;
        }

        SecureRandom random = new SecureRandom();
        BigInteger x = new BigInteger(p.bitLength(), random);
        while (x.compareTo(two) < 0 || x.compareTo(minusOne) >= 0) {
            x = new BigInteger(p.bitLength(), random);
        }

        BigInteger y = x.modPow(q, p);
        if (y.equals(one)) {
            return false;
        }

        for (int j = 0; j < r; j++) {
            if (y.equals(minusOne)) {
                return false;
            }
            y = y.multiply(y).mod(p);
            if (y.equals(one)) {
                return true;
            }
        }

        return true;
    }
}
