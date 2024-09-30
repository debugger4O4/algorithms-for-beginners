import java.util.*;

public class TopologicalSort {


    // Алгоритм
    public static List<Integer> topologicalSort(List<List<Integer>> adjencyList, int V) {
        List<Integer> sorted = new ArrayList<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfsTopologicalSort(adjencyList, i, visited, sorted);
            }
        }
        return sorted;
    }

    static void dfsTopologicalSort(
            List<List<Integer>> adjencyList,
            int node,
            boolean[] visited,
            List<Integer> sorted
    ) {
        visited[node] = true;
        for (int i : adjencyList.get(node)) {
            if (!visited[i]) {
                dfsTopologicalSort(adjencyList, i, visited, sorted);
            }
        }
        sorted.add(0, node);
    }
}
