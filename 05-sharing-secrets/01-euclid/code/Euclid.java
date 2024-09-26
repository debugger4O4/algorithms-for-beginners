public class Euclid {

    public static int euclid(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return euclid(b, a % b);
        }
    }
}
