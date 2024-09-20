import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriorityQueueExtractMinTest {
    @Test
    void test() {

        MinHeap pq = new MinHeap();
        pq.initTestData();
        assertEquals(5, PriorityQueueExtractMin.extractMinFromPQ(pq));
        /*
            [5, 8, 6, 11, 13, 19, 17, 12] ->
            [12, 8, 6, 11, 13, 19, 17] ->
            [6, 8, 12, 11, 13, 19, 17]
         */
    }

    static class MinHeap {
        public ArrayList<Integer> heap;

        // Тестовые данные
        public void initTestData() {
            this.heap.add(5);
            this.heap.add(8);
            this.heap.add(6);
            this.heap.add(11);
            this.heap.add(13);
            this.heap.add(19);
            this.heap.add(17);
            this.heap.add(12);
        }

        public MinHeap() {
            heap = new ArrayList<>();
        }

        public int parent(int i) {
            return (i - 1) / 2;
        }

        public void exchange(int i, int j) {
            int temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }
    }
}
