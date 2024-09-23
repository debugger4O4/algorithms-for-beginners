public class InsertInPQ {

    // Алгоритм
    public static void insertInPq(InsertInPQTest.MinHeap pq, Integer c) {
        int root = 0;
        pq.heap.add(c);
        c = pq.heap.size() - 1;
        while (c != root && pq.heap.get(c) < pq.heap.get(pq.parent(c))) {
            int p = pq.parent(c);
            pq.exchange(c, p);
            c = pq.parent(c);
        }
    }
}
