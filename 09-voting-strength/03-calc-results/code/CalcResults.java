import java.util.ArrayList;
import java.util.List;

public class CalcResults {

    // Алгоритм
    public static List<List<Integer>> calcResults(int[][] S, int n) {
        List<List<Integer>> wins = createListOfLists(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && S[i][j] > S[j][i]) {
                    wins.get(i).add(j);
                }
            }
        }

        return wins;
    }

    private static List<List<Integer>> createListOfLists(int n) {
        List<List<Integer>> listOfLists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            listOfLists.add(new ArrayList<>());
        }
        return listOfLists;
    }
}
