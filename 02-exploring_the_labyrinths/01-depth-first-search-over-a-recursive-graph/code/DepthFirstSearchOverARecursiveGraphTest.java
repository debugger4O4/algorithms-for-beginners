import org.junit.jupiter.api.Test;

public class DepthFirstSearchOverARecursiveGraphTest {

    @Test
    void test() {
        DepthFirstSearchOverARecursiveGraph graph = new DepthFirstSearchOverARecursiveGraph(8);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 3);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);

        graph.getDFS(0); // 0 1 4 5 3 6 7 2
    }
}
