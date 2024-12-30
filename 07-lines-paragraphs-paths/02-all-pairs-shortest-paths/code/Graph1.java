import java.util.ArrayList;
import java.util.List;

public class Graph1 {
    List<List<Edge>> adjList;

    public Graph1(int numVertices) {
        this.adjList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest, int weight) {
        adjList.get(src).add(new Edge(dest, weight));
    }
}