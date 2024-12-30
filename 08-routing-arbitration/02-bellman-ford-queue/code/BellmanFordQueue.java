import java.util.*;

public class BellmanFordQueue {

    // Алгоритм
    static Pair<int[], int[]> bellmanFordQueue(Graph g, int startVertex) {
        int[] distance = new int[g.numVertices];
        int[] predecessor = new int[g.numVertices];
        boolean[] inQueue = new boolean[g.numVertices];

        Queue<Integer> queue = new LinkedList<>();

        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(predecessor, -1);

        distance[startVertex] = 0;
        queue.offer(startVertex);
        inQueue[startVertex] = true;

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            inQueue[currentVertex] = false;

            for (Edge edge : g.adjacencyList.get(currentVertex)) {
                int neighbor = edge.destination;

                int newDistance = distance[currentVertex] + edge.weight;

                if (newDistance < distance[neighbor]) {
                    distance[neighbor] = newDistance;
                    predecessor[neighbor] = currentVertex;

                    if (!inQueue[neighbor]) {
                        queue.offer(neighbor);
                        inQueue[neighbor] = true;
                    }
                }
            }
        }

        return new Pair<>(predecessor, distance);
    }

    static class Graph {
        int numVertices;
        List<List<Edge>> adjacencyList;

        public Graph(int numVertices) {
            this.numVertices = numVertices;
            adjacencyList = new ArrayList<>();

            for (int i = 0; i < numVertices; ++i) {
                adjacencyList.add(new ArrayList<>());
            }
        }

        void addEdge(int u, int v, int weight) {
            Edge edge = new Edge(u, v, weight);
            adjacencyList.get(u).add(edge);
        }
    }

    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Pair<T, U> {
        T first;
        U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }
    }
}