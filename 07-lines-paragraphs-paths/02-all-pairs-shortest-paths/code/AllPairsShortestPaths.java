import java.util.Arrays;
import java.util.PriorityQueue;

public class AllPairsShortestPaths {

    // Алгоритм
    public static Pair<int[][], int[][]> allPairsShortestPaths(Graph1 g) {
        int numVertices = g.adjList.size();
        int[][] preds = new int[numVertices][numVertices];
        int[][] dists = new int[numVertices][numVertices];

        for (int u = 0; u < numVertices; u++) {
            DijkstraResult result = dijkstra(g, u);
            for (int v = 0; v < numVertices; v++) {
                preds[u][v] = result.predecessors[v];
                dists[u][v] = result.distances[v];
            }
        }

        return new Pair<>(preds, dists);
    }

    public static DijkstraResult dijkstra(Graph1 g, int source) {
        int numVertices = g.adjList.size();
        int[] distances = new int[numVertices];
        int[] predecessors = new int[numVertices];

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[numVertices];

        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(predecessors, -1);

        distances[source] = 0;
        pq.offer(new Edge(source, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int u = current.vertex;

            if (visited[u]) continue;
            visited[u] = true;

            for (Edge edge : g.adjList.get(u)) {
                int v = edge.vertex;
                int weight = edge.weight;

                if (!visited[v] && distances[u] != Integer.MAX_VALUE &&
                        distances[u] + weight < distances[v]) {
                    distances[v] = distances[u] + weight;
                    predecessors[v] = u;
                    pq.offer(new Edge(v, distances[v]));
                }
            }
        }

        return new DijkstraResult(distances, predecessors);
    }

}
