import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DepthFirstSearchOverAGraphUsingAStackTest {

    @Test
    void test() {
        DepthFirstSearchOverAGraphUsingAStack graph = new DepthFirstSearchOverAGraphUsingAStack(8);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);
        graph.addEdge(1, 0);
        graph.addEdge(4, 1);
        graph.addEdge(4, 5);
        graph.addEdge(5, 4);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(5, 3);
        graph.addEdge(2, 0);
        graph.addEdge(3, 5);
        graph.addEdge(3, 0);
        graph.addEdge(7, 5);
        graph.addEdge(6, 5);

        boolean[] answer = {true, true, true, true, true, true, true, true};

        assertTrue(
                answer.length == graph.getStackDFS(0).length
                && Arrays.equals(answer, graph.getStackDFS(0))
        );
    }
}
