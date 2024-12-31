import java.util.ArrayDeque;
import java.util.Queue;

public class BellmanFordQueueNc {

    // Алгоритм
    public static Result bellmanFordQueueNc(int[][] G, int s) {
        int n = G.length;
        int[] dist = new int[n];
        int[] pred = new int[n];
        boolean[] inQueue = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; ++i) {
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }
        dist[s] = 0;

        queue.add(s);
        inQueue[s] = true;

        queue.add(n);

        int iterations = 0;
        while (!queue.isEmpty() && iterations < n) {
            int u = queue.poll();
            inQueue[u] = false;

            if (u == n) {
                if (!queue.isEmpty()) {
                    queue.add(n);
                    iterations++;
                }
            } else {
                for (Edge edge : getEdges(G, u)) {
                    int v = edge.to;
                    int weight = edge.weight;

                    if (dist[v] > dist[u] + weight) {
                        dist[v] = dist[u] + weight;
                        pred[v] = u;

                        if (!inQueue[v]) {
                            queue.add(v);
                            inQueue[v] = true;
                        }
                    }
                }
            }
        }

        boolean hasNegativeCycle = iterations >= n;

        return new Result(pred, dist, !hasNegativeCycle);
    }

    private static Edge[] getEdges(int[][] graph, int u) {
        int count = 0;
        for (int v = 0; v < graph.length; v++) {
            if (graph[u][v] != 0) {
                count++;
            }
        }

        Edge[] edges = new Edge[count];
        int index = 0;
        for (int v = 0; v < graph.length; v++) {
            if (graph[u][v] != 0) {
                edges[index++] = new Edge(u, v, graph[u][v]);
            }
        }

        return edges;
    }

    private static class Edge {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static class Result {
        int[] pred;
        int[] dist;
        boolean noNegativeCycle;

        public Result(int[] pred, int[] dist, boolean noNegativeCycle) {
            this.pred = pred;
            this.dist = dist;
            this.noNegativeCycle = noNegativeCycle;
        }
    }
}
