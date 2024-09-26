import java.util.LinkedList;

/**
 * Depth-first search (Поиск в глубину)
 */
public class DFS {

    private final LinkedList<Integer>[] adjacencyList;
    private final boolean[] visited;

    // Создание графа
    DFS(int vertices) {
        adjacencyList = new LinkedList[vertices];
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Добавление ребер
    void addEdge(int src, int dest) {
        adjacencyList[src].add(dest);
    }

    // Алгоритм
    public void dfs(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int adj : adjacencyList[vertex]) {
            if (!visited[adj]) {
                dfs(adj);
            }
        }
    }
}
