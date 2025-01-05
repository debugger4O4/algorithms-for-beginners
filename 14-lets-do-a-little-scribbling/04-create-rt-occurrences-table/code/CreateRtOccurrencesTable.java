import java.util.ArrayList;
public class CreateRtOccurrencesTable {

    // Алгоритм
    public static ArrayList<Integer> createRtOccurrencesTable(String p, String t, int s) {
        ArrayList<Integer> rt = new ArrayList<>(s);
        int m = p.length();
        for (int i = 0; i < m; i++) {
            rt.set(i, m);
        }
        for (int i = 0; i < m; i++) {
            int r = m - i - 1;
            if (r >= 1 && p.charAt(i) == t.charAt(r)) {
                rt.set(i, r);
            } else if (r >= 1 && p.charAt(i) != t.charAt(r)) {
                rt.set(i, m - r);
            }
        }
        return rt;
    }
}
