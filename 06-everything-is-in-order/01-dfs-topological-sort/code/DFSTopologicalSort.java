import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DFSTopologicalSort {

    private final List<Integer> sorted = new ArrayList<>();
    private final LinkedList<Integer>[] adjacencyList;
    private final boolean[] visited;

    // Создание графа
    DFSTopologicalSort(int vertices) {
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
    public void dfsTopologicalSort(int node) {
        visited[node] = true;
        for (int v : adjacencyList[node]) {
            if (!visited[v]) {
                dfsTopologicalSort(v);
            }
        }
        sorted.add(node);
        System.out.println(sorted);
    }
}
