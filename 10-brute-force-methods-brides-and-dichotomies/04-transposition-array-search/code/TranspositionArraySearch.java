public class TranspositionArraySearch {

    // Алгоритм
    public static int transpositionArraySearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                if (i > 0) {
                    swap(array, i - 1, i);
                }
                return i - 1;
            }
        }
        return -1;
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
