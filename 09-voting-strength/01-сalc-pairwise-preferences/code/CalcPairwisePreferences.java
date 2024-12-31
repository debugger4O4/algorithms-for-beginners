public class CalcPairwisePreferences {

    // Алгоритм
    public static int[][] calcPairwisePreferences(int[][] ballots, int m) {

        int[][] P = new int[m][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                P[i][j] = 0;
            }
        }

        for (int[] ballot : ballots) {
            for (int j = 0; j < ballot.length; j++) {
                int cj = ballot[j];

                for (int k = j + 1; k < ballot.length; k++) {
                    int ck = ballot[k];

                    P[cj][ck]++;
                }
            }
        }

        return P;
    }
}
