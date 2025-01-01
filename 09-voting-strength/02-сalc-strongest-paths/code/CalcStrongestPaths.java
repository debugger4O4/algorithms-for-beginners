public class CalcStrongestPaths {

        private static int[][] createArray(int n) {
            return new int[n][n];
        }

        // Алгоритм
        public static Pair1<int[][], int[][]> calcStrongestPaths(int[][] W, int n) {
            int[][] S = createArray(n);
            int[][] pred = createArray(n);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (W[i][j] > W[j][i]) {
                        S[i][j] = W[i][j] - W[j][i];
                        pred[i][j] = i;
                    } else {
                        S[i][j] = Integer.MIN_VALUE;
                        pred[i][j] = -1;
                    }
                }
            }

            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    if (i != k) {
                        for (int j = 0; j < n; j++) {
                            if (j != i && j != k) {
                                if (S[i][j] < Math.min(S[i][k], S[k][j])) {
                                    S[i][j] = Math.min(S[i][k], S[k][j]);
                                    pred[i][j] = pred[k][j];
                                }
                            }
                        }
                    }
                }
            }

            return new Pair1<>(S, pred);
        }
}
