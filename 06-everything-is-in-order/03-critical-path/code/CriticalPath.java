import java.util.*;

public class CriticalPath {

    // Алгоритм
    public static List<int[]> criticalPath(EdgeWeightedDigraph adjencyList, int s) {
        List<int[]> result = new ArrayList<>();
        int[] pred = new int[adjencyList.V()];
        int[] dist = new int[adjencyList.V()];
        for (int i = 0; i < adjencyList.V(); i++) {
            pred[i] = -1;
            dist[i] = (int) Double.NEGATIVE_INFINITY;
        }
        dist[s] = 0;
        List<Integer> sorted = topologicalSort(adjencyList, adjencyList.V());
        for (int u : sorted) {
            for (DirectedEdge v : adjencyList.adj(u)) {
                if (dist[v.getFrom()] < dist[u] + (u + v.getTo())) {
                    dist[v.getFrom()] = dist[u] + (u + v.getTo());
                    pred[v.getFrom()] = u;
                }
            }
        }
        result.add(pred);
        result.add(dist);
        return result;
    }
}
