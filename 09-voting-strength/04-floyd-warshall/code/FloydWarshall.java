public class FloydWarshall {

    // Аналитики
    public static void floydWarshall(int[][] W, int n, int[][] dist, int[][] pred) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = W[i][j];
                pred[i][j] = i;

                if (W[i][j] == Integer.MAX_VALUE || i == j) {
                    dist[i][j] = Integer.MAX_VALUE;
                    pred[i][j] = -1;
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE &&
                            dist[i][j] > dist[i][k] + dist[k][j]) {

                        dist[i][j] = dist[i][k] + dist[k][j];
                        pred[i][j] = pred[k][j];
                    }
                }
            }
        }
    }
}
