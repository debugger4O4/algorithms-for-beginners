import org.junit.Test;

public class QuickSortTest {

    @Test
    public void test() {
        int[] A = {64, 34, 25, 12, 22, 11, 90};
        System.out.print("Original array: ");
        for (int num : A) {
            System.out.print(num + " ");
        }
        System.out.println();

        QuickSort.quickSort(A, 0, A.length - 1);

        System.out.print("Sorted array: ");
        for (int num : A) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
