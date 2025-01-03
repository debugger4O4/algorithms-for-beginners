public class PerfectMapping {


    // Алгоритм
    public static int perfectMapping(String s) {
        int r = -code(s.charAt(0));

        int sVal = code(s.charAt(1));
        r = r - 8 + sVal;

        if (r <= 0) {
            r = r + 16 + sVal;
        }

        sVal = code(s.charAt(2));
        if (sVal == 0) {
            return r;
        }

        r = r - 28 + sVal;
        if (r > 0) {
            return r;
        }

        r = r + 11 + sVal;

        int t = code(s.charAt(3));
        if (t == 0) {
            return r;
        }

        r = r - (sVal - 5);
        if (r < 0) {
            return r;
        }

        r = r + 10;
        return r;
    }

    private static int code(char c) {
        return (int) c;
    }
}

