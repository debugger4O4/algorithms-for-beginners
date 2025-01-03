import org.junit.Test;

public class HornerRuleTest {

    @Test
    public void test() {
        double[] coefficients = {1, -3, 2};
        double xValue = 2;
        double result = HornerRule.hornerRule(coefficients, xValue);
        System.out.println("Значение многочлена при x=" + xValue + " равно: " + result);
    }

}
