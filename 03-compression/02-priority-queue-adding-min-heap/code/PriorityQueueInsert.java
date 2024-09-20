public class PriorityQueueInsert {

    // Алгоритм
    public static void insertInPq(PriorityQueueInsertTest.MinHeap pq, Integer c) {
        int root = 0;
        pq.heap.add(c);
        int currentIndex = pq.heap.size() - 1;
        while (currentIndex != root && pq.heap.get(currentIndex) < pq.heap.get(pq.parent(currentIndex))) {
            int p = pq.parent(currentIndex);
            pq.exchange(currentIndex, p);
            currentIndex = pq.parent(currentIndex);
        }
    }
}
