import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstGraphSearch {

    private final LinkedList<Integer>[] adjacencyList;
    private final int V;

    // Создание графа
    BreadthFirstGraphSearch(int vertices) {
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
        this.V = vertices;
    }

    // Добавление ребер
    void addEdge(int src, int dest) {
        adjacencyList[src].add(dest);
    }

    // Алгоритм
    public boolean[] getBFS(int vertex) {
        Queue<Integer> Q = new LinkedList<>();
        // По дефолту заполняется false'ами
        boolean[] visited = new boolean[V];
        boolean[] inQueue = new boolean[V];
        Q.add(vertex);
        inQueue[vertex] = true;
        while (!Q.isEmpty()) {
            int c = Q.poll();
            inQueue[c] = false;
            visited[c] = true;
            for (int v : adjacencyList[c]) {
                if (!visited[v] && !inQueue[v]) {
                    Q.add(v);
                    inQueue[v] = true;
                }
            }
        }
        return visited;
    }
}
