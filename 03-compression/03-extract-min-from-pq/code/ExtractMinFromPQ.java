public class ExtractMinFromPQ {

    // Алгоритм
    public static int extractMinFromPQ(ExtractMinFromPQTest.MinHeap pq) {
        int root = 0;
        int c = pq.heap.get(root);
        pq.heap.set(root, pq.heap.remove(pq.heap.size() - 1));
        int i = root;
        while (pq.hasChildren(i)) {
            int j = pq.minChildren(i);

            // Свойство кучи восстановлено
            if (j == i) {
                break;
            }

            if (pq.heap.indexOf(i) < pq.heap.indexOf(j)) {
                return c;
            }
            pq.exchange(i, j);
            i = j;
        }
        return c;
    }
}
