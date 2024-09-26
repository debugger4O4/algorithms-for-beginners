public class ExpRepeatedSquaring {

    public static int expRepeatedSquaring(int g, int x) {
        int c = g;
        int d = x;
        int r = 1;
        while (d > 0) {
            if (d % 2 == 1) {
                r *= c;
            }
            d /= 2;
            c *= c;
        }
        return r;
    }
}
