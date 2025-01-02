public class ArrayMerge {

    // Алгоритм
    public static int[] arrayMerge(int[] A, int[] B) {
        int[] C = createArray(A.length + B.length);
        int i = 0, j = 0, k = 0;

        while (k < C.length) {
            if (i >= A.length) {
                C[k++] = B[j++];
            } else if (j >= B.length) {
                C[k++] = A[i++];
            } else if (compare(A[i], B[j]) <= 0) {
                C[k++] = A[i++];
            } else {
                C[k++] = B[j++];
            }
        }

        return C;
    }

    private static int[] createArray(int size) {
        return new int[size];
    }

    private static int compare(int a, int b) {
        return Integer.compare(a, b);
    }

    public static void main(String[] args) {

    }
}
