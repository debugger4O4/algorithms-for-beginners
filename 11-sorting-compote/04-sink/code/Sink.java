public class Sink {

    // Алгоритм
    public static void sink(int[] arr, int i, int n) {
        boolean placed = false;
        int k = i;
        int j = 2 * k + 1;

        while (!placed && j < n) {
            if (j < n - 1 && compare(arr[j], arr[j + 1]) < 0) {
                j++;
            }
            if (compare(arr[k], arr[j]) >= 0) {
                placed = true;
            } else {
                swap(arr, k, j);
                k = j;
                j = 2 * k + 1;
            }
        }
    }

    private static int compare(int a, int b) {
        return Integer.compare(a, b);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
