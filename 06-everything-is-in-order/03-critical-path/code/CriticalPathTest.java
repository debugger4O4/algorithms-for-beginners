import org.junit.Test;

public class CriticalPathTest {

    @Test
    public void test() {
        int numVertices = 6;
        CriticalPath.Graph graph = new CriticalPath.Graph(numVertices);
        graph.addEdge(0, 1, 5); // u=0, v=1, weight=5
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 3, 6);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 4, 4);
        graph.addEdge(2, 5, 2);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 4, -1);
        graph.addEdge(4, 5, -2);

        int startVertex = 0;
        CriticalPath.Pair<int[], int[]> result = CriticalPath.criticalPath(graph, startVertex, numVertices);
        int[] pred = result.first;
        int[] dist = result.second;

        System.out.println("Критический путь:");
        for (int i = 0; i < numVertices; i++) {
            System.out.printf("Предшественник узла %d: %d\n", i, pred[i]);
            System.out.printf("Длина критического пути до узла %d: %d\n", i, dist[i]);
        }
    }
}
