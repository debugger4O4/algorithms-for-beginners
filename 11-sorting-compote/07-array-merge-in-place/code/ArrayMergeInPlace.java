public class ArrayMergeInPlace {

    // Алгоритм
    public static void arrayMergeInPlace(int[] A, int l, int m, int h) {
        int[] C = new int[h - l + 1];

        // Копируем элементы из A в C
        for (int k = l; k <= h; k++) {
            C[k - l] = A[k];
        }

        // Индексы для левой и правой части массива
        int i = 0;
        int cm = m - l + 1;
        int ch = h - l + 1;
        int j = cm;

        // Сливаем обратно в A
        for (int k = l; k <= h; k++) {
            if (i >= cm) {
                A[k] = C[j];
                j++;
            } else if (j >= ch) {
                A[k] = C[i];
                i++;
            } else if (compare(C[i], C[j]) <= 0) {
                A[k] = C[i];
                i++;
            } else {
                A[k] = C[j];
                j++;
            }
        }
    }

    private static int compare(int a, int b) {
        return Integer.compare(a, b);
    }

}
