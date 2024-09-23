import java.util.LinkedList;
import java.util.Stack;

public class StackDFS {

    private final LinkedList<Integer>[] adjacencyList;
    private final int V;

    // Создание графа
    StackDFS(int vertices) {
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
    public boolean[] stackDFS(int vertex) {
        Stack<Integer> S = new Stack<>();
        // По дефолту заполняется false'ами
        boolean[] visited = new boolean[V];
        S.push(vertex);
        while (!S.empty()) {
            int c = S.pop();
            visited[c] = true;
            for (int v : adjacencyList[c]) {
                if (!visited[v]) {
                    S.push(v);
                }
            }
        }
        return visited;
    }
}
