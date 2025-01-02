public class QuickSort {

    // Алгоритм
    public static void quickSort(int[] A, int l, int h) {
        if (l < h) {
            int p = partition(A, l, h);
            quickSort(A, l, p - 1);
            quickSort(A, p + 1, h);
        }
    }

    private static int compare(int a, int b) {
        return Integer.compare(a, b);
    }

    private static int partition(int[] A, int l, int h) {
        int pivot = A[h];
        int i = l - 1;

        for (int j = l; j < h; j++) {
            if (compare(A[j], pivot) <= 0) {
                i++;
                swap(A, i, j);
            }
        }
        swap(A, i + 1, h);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
