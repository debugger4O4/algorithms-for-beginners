import org.junit.Test;

import java.util.Arrays;

public class HeapSortTest {

    @Test
    public void test() {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        HeapSort.heapSort(arr);
        System.out.println("Отсортированный массив: " + Arrays.toString(arr));
    }
}
