import org.junit.jupiter.api.Test;

public class DFSTest {

    @Test
    void test() {
        DFS graph = new DFS(8);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);
        graph.addEdge(1, 0);
        graph.addEdge(4, 1);
        graph.addEdge(4, 5);
        graph.addEdge(5, 4);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(5, 3);
        graph.addEdge(2, 0);
        graph.addEdge(3, 5);
        graph.addEdge(3, 0);
        graph.addEdge(7, 5);
        graph.addEdge(6, 5);

        graph.dfs(0); // 0 1 4 5 3 6 7 2
    }
}
