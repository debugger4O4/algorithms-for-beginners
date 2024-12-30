import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class DijkstraTest {

    @Test
    public void test() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);

        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);

        nodeC.addDestination(nodeE, 10);

        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeF, 1);

        nodeF.addDestination(nodeE, 5);

        Graph graph = new Graph();

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        Dijkstra.dijkstra(graph, nodeA);
        /*
        Узел B : A –> B (общее расстояние = 10)
        Узел C : A –> C (общее расстояние = 15)
        Узел D : A –> B –> D (общее расстояние = 22)
        Узел E : A –> B –> D –> E (общее расстояние = 24)
        Узел F : A –> B –> D –> F (общее расстояние = 23)
         */
    }
}
