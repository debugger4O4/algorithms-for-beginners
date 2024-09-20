public class SimpleStockSpan {

    // Алгоритм
    public static int[] getSimpleStockSpan(int[] quotes) {
        int[] spans = new int[quotes.length];
        for (int i = 0; i < spans.length; i++) {
            int k = 1;
            boolean spanEnd = false;
            while (i - k >= 0 && !spanEnd) {
                if (quotes[i - k] <= quotes[i]) {
                    k += 1;
                } else {
                    spanEnd = true;
                }
            }
            spans[i] = k;
        }
        return spans;
    }
}
