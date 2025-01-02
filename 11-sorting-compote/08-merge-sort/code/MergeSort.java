public class MergeSort {

    // Алгоритм
    public static void mergeSort(int[] A, int l, int h) {
        if (l < h) {
            int m = l + (h - l) / 2;
            mergeSort(A, l, m);
            mergeSort(A, m + 1, h);
            arrayMergeInPlace(A, l, m, h);
        }
    }

    private static int compare(int a, int b) {
        return Integer.compare(a, b);
    }

    private static void arrayMergeInPlace(int[] A, int l, int m, int h) {
        int[] C = new int[h - l + 1];

        for (int k = l; k <= h; k++) {
            C[k - l] = A[k];
        }

        int i = 0;
        int cm = m - l + 1;
        int ch = h - l + 1;
        int j = cm;

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
}
