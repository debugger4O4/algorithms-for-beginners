import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TopologicalSortTest {

    public List<List<Integer>> DAG;
    int V;

    public void createDAG() {
        V = 11;

        // Ребра
        List<List<Integer>> edges = new ArrayList<>();

        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(0, 3));
        edges.add(Arrays.asList(1, 2));
        edges.add(Arrays.asList(3, 4));
        edges.add(Arrays.asList(4, 2));
        edges.add(Arrays.asList(4, 5));
        edges.add(Arrays.asList(6, 3));
        edges.add(Arrays.asList(6, 7));
        edges.add(Arrays.asList(8, 6));
        edges.add(Arrays.asList(8, 9));
        edges.add(Arrays.asList(9, 7));
        edges.add(Arrays.asList(10, 0));

        DAG = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            DAG.add(new ArrayList<>());
        }

        for (List<Integer> i : edges) {
            DAG.get(i.get(0)).add(i.get(1));
        }
    }

    @Test
    void test() {
        createDAG();
        assertEquals("[10, 8, 9, 6, 7, 0, 3, 4, 5, 1, 2]", TopologicalSort.topologicalSort(DAG, V) + "");
    }
}
