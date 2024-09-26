import org.junit.jupiter.api.Test;

public class DFSTopologicalSortTest {
    @Test
    void test() {
        DFSTopologicalSort graph = new DFSTopologicalSort(11);

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 0);
        graph.addEdge(3, 0);
        graph.addEdge(3, 4);
        graph.addEdge(3, 6);
        graph.addEdge(2, 1);
        graph.addEdge(2, 4);
        graph.addEdge(4, 2);
        graph.addEdge(4, 3);
        graph.addEdge(4, 5);
        graph.addEdge(5, 4);
        graph.addEdge(8, 6);
        graph.addEdge(8, 9);
        graph.addEdge(6, 3);
        graph.addEdge(6, 7);
        graph.addEdge(6, 8);
        graph.addEdge(9, 7);
        graph.addEdge(9, 8);
        graph.addEdge(7, 6);
        graph.addEdge(7, 9);
        graph.addEdge(10, 0);

        graph.dfsTopologicalSort(10); /*
                                            [8]
                                            [8, 9]
                                            [8, 9, 7]
                                            [8, 9, 7, 6]
                                            [8, 9, 7, 6, 3]
                                            [8, 9, 7, 6, 3, 5]
                                            [8, 9, 7, 6, 3, 5, 4]
                                            [8, 9, 7, 6, 3, 5, 4, 2]
                                            [8, 9, 7, 6, 3, 5, 4, 2, 1]
                                            [8, 9, 7, 6, 3, 5, 4, 2, 1, 0]
                                            [8, 9, 7, 6, 3, 5, 4, 2, 1, 0, 10]
                                      */
    }
}
