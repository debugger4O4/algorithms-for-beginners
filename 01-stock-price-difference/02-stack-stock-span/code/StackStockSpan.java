import java.util.Stack;

public class StackStockSpan {

    // Алгоритм
    public static int[] stackStockSpan(int[] quotes) {
        int[] spans = new int[quotes.length];
        spans[0] = 1;
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for (int i = 1; i < spans.length; i++) {
            while (!s.empty() && quotes[s.peek()] <= quotes[i]) {
                s.pop();
            }
            if (s.empty()) {
                spans[i] = i + 1;
            } else {
                spans[i] = i - (s.peek());
            }
            s.push(i);
        }
        return spans;
    }
}
