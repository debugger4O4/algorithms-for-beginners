import org.junit.Test;

public class FactorTwoTest {

    @Test
    public void test() {
        int n = 24;
        System.out.println("Входное значение n: " + n);

        int[] result = FactorTwo.factorTwo(n);
        if (result != null) {
            System.out.println("Результат: (" + result[0] + ", " + result[1] + ")");
        } else {
            System.out.println("Ошибка: Входное значение должно быть четным числом.");
        }
    }
}
