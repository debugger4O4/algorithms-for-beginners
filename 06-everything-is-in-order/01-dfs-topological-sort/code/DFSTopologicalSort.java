import java.util.List;
import java.util.Stack;

public class DFSTopologicalSort {

    // Алгоритм
    public static void dfsTopologicalSort(
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

        // Поместить текущую вершину в стек, в котором хранится результат
        sorted.push(node);
    }
}
