public class ModExpRepeatedSquaring {

    public static int modExpRepeatedSquaring(int g, int x, int p) {
        int c = g % p;
        int d = x;
        int r = 1;
        while (d > 0) {
            if (d % 2 == 1) {
                r = (r * c) % p;
            }
            d /= 2;
            c = (c * c) % p;
        }
        return r;
    }
}
