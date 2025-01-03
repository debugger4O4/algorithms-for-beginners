public class HornerRule {

    // Алгоритм
    public static double hornerRule(double[] A, double x) {
        double r = 0;

        for (double c : A) {
            r = r * x + c;
        }

        return r;
    }
}
