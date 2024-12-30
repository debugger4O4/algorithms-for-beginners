import org.junit.Test;

import java.util.Arrays;

public class AllPairsShortestPathsTest {

    @Test
    public void test() {
        Graph1 g = new Graph1(5); // Граф с 5 вершинами

        // Добавление рёбер (пример)
        g.addEdge(0, 1, 10);
        g.addEdge(0, 2, 20);
        g.addEdge(1, 3, 30);
        g.addEdge(2, 3, 40);
        g.addEdge(3, 4, 50);

        Pair<int[][], int[][]> result = AllPairsShortestPaths.allPairsShortestPaths(g);
        int[][] preds = result.first;
        int[][] dists = result.second;

        // Вывод результатов
        System.out.println("Предшественники:");
        for (int[] row : preds) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("\nРасстояния:");
        for (int[] row : dists) {
            System.out.println(Arrays.toString(row));
        }
    }
}
