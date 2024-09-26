/**
 * Эта функция выполняет расширенный алгоритм Евклида для двух чисел a и b. Функция возвращает НОД(a,b), а также числа
 * x и y, например что ax + by = euclid(a,b). Этот расчет важен в теории чисел и может использоваться для нескольких целей,
 * таких как поиск обратных модулей и решения линейных диофантовых уравнений
 */
public class ExtendedEuclid {

    public static int[] extendedEuclid(int a, int b) {
        if (b == 0) {
            return new int[]{a, 1, 0};
        } else {
            int[] rxy = extendedEuclid(b, a % b);
            int tmp = rxy[1] - rxy[2] * (a / b);
            rxy[1] = rxy[2];
            rxy[2] = tmp;
            return rxy;
        }
    }
}
