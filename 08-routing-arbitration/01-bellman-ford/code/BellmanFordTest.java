import org.junit.Test;

public class BellmanFordTest {

    @Test
    public void test() {
        int V = 5;
        int E = 8;
        BellmanFord graph = new BellmanFord(V, E);

        graph.edge[0].source = 0;
        graph.edge[0].destination = 1;
        graph.edge[0].weight = -1;

        graph.edge[1].source = 0;
        graph.edge[1].destination = 2;
        graph.edge[1].weight = 4;

        graph.edge[2].source = 1;
        graph.edge[2].destination = 2;
        graph.edge[2].weight = 3;

        graph.edge[3].source = 1;
        graph.edge[3].destination = 3;
        graph.edge[3].weight = 2;

        graph.edge[4].source = 1;
        graph.edge[4].destination = 4;
        graph.edge[4].weight = 2;

        graph.edge[5].source = 3;
        graph.edge[5].destination = 2;
        graph.edge[5].weight = 5;

        graph.edge[6].source = 3;
        graph.edge[6].destination = 1;
        graph.edge[6].weight = 1;

        graph.edge[7].source = 4;
        graph.edge[7].destination = 3;
        graph.edge[7].weight = -3;

        graph.bellmanFord(graph, 0); /*
                                        Расстояние вершины от источника:
                                        0       0
                                        1       -1
                                        2       2
                                        3       -2
                                        4       1
                                      */
    }
}
