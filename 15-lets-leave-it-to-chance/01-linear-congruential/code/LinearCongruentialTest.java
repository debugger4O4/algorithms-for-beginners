import org.junit.Test;

public class LinearCongruentialTest {

    @Test
    public void test() {
        int m = 10000;   // Модуль
        int a = 12345;   // Множитель
        int c = 6789;    // Приращение
        int seed = 7;    // Начальное значение (seed)

        LinearCongruential generator = new LinearCongruential(m, a, c);

        System.out.println("Последовательность случайных чисел:");
        for (int i = 0; i < 10; i++) {
            seed = generator.linearCongruential(seed); // Генерация следующего числа
            System.out.println(seed);
        }
    }
}
