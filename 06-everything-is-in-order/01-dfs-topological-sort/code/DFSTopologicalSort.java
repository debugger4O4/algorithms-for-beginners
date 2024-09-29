import java.util.List;
import java.util.Stack;

public class DFSTopologicalSort {

    // Алгоритм
    public static void dfsTopologicalSort(
            List<List<Integer>> adj, int node,
            boolean[] visited,
            Stack<Integer> stack
    ) {
        visited[node] = true;
        for (int i : adj.get(node)) {
            if (!visited[i]) {
                dfsTopologicalSort(adj, i, visited, stack);
            }
        }

        // Поместить текущую вершину в стек, в котором хранится результат
        stack.push(node);
    }
}
