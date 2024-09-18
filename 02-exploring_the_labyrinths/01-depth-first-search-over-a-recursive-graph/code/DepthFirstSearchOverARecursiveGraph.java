import java.util.LinkedList;

public class DepthFirstSearchOverARecursiveGraph {

    private LinkedList<Integer> adjacencyList[];
    private boolean visited[];

    // Создание графа
    DepthFirstSearchOverARecursiveGraph(int vertices) {
        adjacencyList = new LinkedList[vertices];
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++)
            adjacencyList[i] = new LinkedList<>();
    }

    // Добавление ребер
    void addEdge(int src, int dest) {
        adjacencyList[src].add(dest);
    }

    // Алгоритм
    public void getDFS(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int adj : adjacencyList[vertex]) {
            if (!visited[adj])
                getDFS(adj);
        }
    }
}
