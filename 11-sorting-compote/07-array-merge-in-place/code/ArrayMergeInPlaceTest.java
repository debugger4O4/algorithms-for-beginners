import org.junit.Test;

public class ArrayMergeInPlaceTest {

    @Test
    public void test() {
        int[] A = {1, 3, 5, 7, 2, 4, 6, 8};
        int l = 0;
        int m = 3;
        int h = 7;

        System.out.print("Original array: ");
        for (int num : A) {
            System.out.print(num + " ");
        }
        System.out.println();

        ArrayMergeInPlace.arrayMergeInPlace(A, l, m, h);

        System.out.print("Sorted array: ");
        for (int num : A) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
