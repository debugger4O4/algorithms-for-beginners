import org.junit.Test;

public class ArrayMergeTest {

    @Test
    public void test() {
        int[] A = {1, 3, 5, 7};
        int[] B = {2, 4, 6, 8};
        int[] C = ArrayMerge.arrayMerge(A, B);

        System.out.print("Merged array: ");
        for (int num : C) {
            System.out.print(num + " ");
        }
    }
}
