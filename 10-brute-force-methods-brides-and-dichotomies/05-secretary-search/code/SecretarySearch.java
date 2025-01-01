public class SecretarySearch {

    // Алгоритм
    public static int secretarySearch(int[] candidates) {
        double e = Math.E;
        int m = (int) Math.ceil(candidates.length / e);
        int bestCandidateSoFar = 0;

        for (int i = 1; i <= m; i++) {
            if (candidates[i] > candidates[bestCandidateSoFar]) {
                bestCandidateSoFar = i;
            }
        }

        for (int i = m + 1; i < candidates.length; i++) {
            if (candidates[i] > candidates[bestCandidateSoFar]) {
                return i;
            }
        }

        return -1;
    }
}
