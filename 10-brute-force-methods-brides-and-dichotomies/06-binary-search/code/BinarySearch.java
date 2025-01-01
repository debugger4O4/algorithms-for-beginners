public class BinarySearch {

    // Алгоритм
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            int comparisonResult = compare(array[middle], target);

            if (comparisonResult < 0) {
                left = middle + 1;
            } else if (comparisonResult > 0) {
                right = middle - 1;
            } else {
                return middle;
            }
        }

        return -1;
    }

    private static int compare(int first, int second) {
        return Integer.compare(first, second);
    }
}
