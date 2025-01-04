import java.util.*;

public class CriticalPath {

    // Алгоритм
    public static Pair<int[], int[]> criticalPath(Graph graph, int startVertex, int numVertices) {
        int[] pred = new int[numVertices];
        int[] dist = new int[numVertices];
        Arrays.fill(pred, -1);
        Arrays.fill(dist, Integer.MIN_VALUE);
        dist[startVertex] = 0;

        int[] sorted = topologicalSort(graph, numVertices);
        for (int u : sorted) {
            for (Edge edge : graph.getEdges(u)) {
                int v = edge.v;
                int weight = edge.weight;
                if (dist[v] < dist[u] + weight) {
                    dist[v] = dist[u] + weight;
                    pred[v] = u;
                }
            }
        }

        return new Pair<>(pred, dist);
    }


    public static int[] topologicalSort(Graph graph, int numVertices) {
        boolean[] visited = new boolean[numVertices];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited, stack);
            }
        }

        int[] sorted = new int[numVertices];
        int index = 0;
        while (!stack.isEmpty()) {
            sorted[index++] = stack.pop();
        }

        return sorted;
    }

    private static void dfs(Graph graph, int vertex, boolean[] visited, Deque<Integer> stack) {
        visited[vertex] = true;
        for (Edge edge : graph.getEdges(vertex)) {
            if (!visited[edge.v]) {
                dfs(graph, edge.v, visited, stack);
            }
        }
        stack.push(vertex);
    }

    public static class Graph {
        private Map<Integer, List<Edge>> adjacencyList;

        public Graph(int numVertices) {
            this.adjacencyList = new HashMap<>();
            for (int i = 0; i < numVertices; i++) {
                adjacencyList.put(i, new ArrayList<>());
            }
        }

        public void addEdge(int u, int v, int weight) {
            Edge edge = new Edge(u, v, weight);
            adjacencyList.get(u).add(edge);
        }

        public List<Edge> getEdges(int u) {
            return adjacencyList.get(u);
        }
    }

    public static class Edge {
        int u, v, weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    public static class Pair<T, U> {
        T first;
        U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }
    }
}