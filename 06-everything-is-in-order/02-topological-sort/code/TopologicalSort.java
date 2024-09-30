import java.util.*;

public class TopologicalSort {


    // Алгоритм
    public static void topologicalSort(List<List<Integer>> adjencyList, int V) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfsTopologicalSort(adjencyList, i, visited, stack);
            }
        }
    }

    static void dfsTopologicalSort(
            List<List<Integer>> adjencyList,
            int node,
            boolean[] visited,
            Stack<Integer> sorted
    ) {
        visited[node] = true;
        for (int i : adjencyList.get(node)) {
            if (!visited[i]) {
                dfsTopologicalSort(adjencyList, i, visited, sorted);
            }
        }
        sorted.push(node);
    }
}
