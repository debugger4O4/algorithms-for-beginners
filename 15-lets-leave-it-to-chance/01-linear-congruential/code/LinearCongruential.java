public class LinearCongruential {

    private final int m; // Модуль
    private final int a; // Множитель
    private final int c; // Приращение

    public LinearCongruential(int m, int a, int c) {
        this.m = m;
        this.a = a;
        this.c = c;
    }

    // Алгоритм
    public int linearCongruential(int x) {
        if (x < 0 || x >= m) {
            throw new IllegalArgumentException("Значение x должно быть в пределах от 0 до m-1");
        }

        return (a * x + c) % m;
    }
}
