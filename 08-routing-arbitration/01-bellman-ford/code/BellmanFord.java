import java.util.Arrays;

public class BellmanFord {

    int V, E;
    Edge[] edge;

    BellmanFord(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    // Алгоритм
    void bellmanFord(BellmanFord G, int s) {
        int V = G.V, E = G.E;
        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = G.edge[j].source;
                int v = G.edge[j].destination;
                int weight = G.edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
                    dist[v] = dist[u] + weight;
            }
        }

        for (int j = 0; j < E; ++j) {
            int u = G.edge[j].source;
            int v = G.edge[j].destination;
            int weight = G.edge[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("График содержит цикл отрицательного веса");
                return;
            }
        }

        printDistances(dist, V);
    }

    void printDistances(int[] dist, int V) {
        System.out.println("Расстояние вершины от источника:");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }

    static class Edge {
        int source, destination, weight;

        Edge() {
            source = destination = weight = 0;
        }
    }
}
