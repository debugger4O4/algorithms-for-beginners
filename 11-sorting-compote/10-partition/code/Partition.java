public class Partition {

    // Алгоритм
    public static int partition(int[] A, int l, int h) {
        int pivot = pickElement(A);
        swap(A, h, h);
        int b = l;

        for (int i = l; i < h; i++) {
            if (compare(A[i], pivot) < 0) {
                swap(A, i, b);
                b++;
            }
        }

        swap(A, h, b);
        return b;
    }

    private static int compare(int a, int b) {
        return Integer.compare(a, b);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int pickElement(int[] A) {
        return A[A.length - 1];
    }
}
