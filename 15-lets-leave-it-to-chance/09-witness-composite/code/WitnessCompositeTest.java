import org.junit.Test;

import java.math.BigInteger;

public class WitnessCompositeTest {

    @Test
    public void test() {
        BigInteger p = BigInteger.valueOf(561);
        boolean result = WitnessComposite.witnessComposite(p);
        System.out.println(result ? "Число составное." : "Не удалось доказать, что число составное.");
    }
}
