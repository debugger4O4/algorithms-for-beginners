import org.junit.Test;

public class PartitionTest {

    @Test
    public void test() {
        int[] A = {64, 34, 25, 12, 22, 11, 90};
        int l = 0;
        int h = A.length - 1;

        System.out.print("Original array: ");
        for (int num : A) {
            System.out.print(num + " ");
        }
        System.out.println();

        int b = Partition.partition(A, l, h);

        System.out.print("Partitioned array: ");
        for (int num : A) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("Pivot index: " + b);
    }
}
