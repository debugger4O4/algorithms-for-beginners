public class PriorityQueueAddingMinHeap {

    // Алгоритм
    public static void insertInPq(PriorityQueueAddingMinHeapTest.MinHeap pq, Integer c) {
        int root = 0;
        System.out.println(pq.heap);
        pq.heap.add(c);
        System.out.println(pq.heap);
        int currentIndex = pq.heap.size() - 1;
        while (currentIndex != root && pq.heap.get(currentIndex) < pq.heap.get(pq.parent(currentIndex))) {
            int p = pq.parent(currentIndex);
            pq.exchange(currentIndex, p);
            currentIndex = pq.parent(currentIndex);
            System.out.println(pq.heap);
        }
    }
}
