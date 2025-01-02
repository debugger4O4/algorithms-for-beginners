public class SelectionSortCheckExchanges {

    // Алгоритм
    public static void selectionSortCheckExchanges(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (compare(arr[j], arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            if (i != minIndex) {
                swap(arr, i, minIndex);
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
