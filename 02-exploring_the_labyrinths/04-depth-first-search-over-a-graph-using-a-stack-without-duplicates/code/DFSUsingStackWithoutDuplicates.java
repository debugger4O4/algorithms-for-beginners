import java.util.LinkedList;
import java.util.Stack;

public class DFSUsingStackWithoutDuplicates {

    private final LinkedList<Integer>[] adjacencyList;
    private final int V;

    // Создание графа
    DFSUsingStackWithoutDuplicates(int vertices) {
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
    public boolean[] getStackWithoutDuplicatesDFS(int vertex) {
        Stack<Integer> S = new Stack<>();
        // По дефолту заполняется false'ами
        boolean[] visited = new boolean[V];
        boolean[] inStack = new boolean[V];
        S.push(vertex);
        inStack[vertex] = true;
        while (!S.empty()) {
            int c = S.pop();
            inStack[c] = false;
            visited[c] = true;
            for (int v : adjacencyList[c]) {
                if (!visited[v] && !inStack[v]) {
                    S.push(v);
                    inStack[v] = true;
                }
            }
        }
        return visited;
    }
}
