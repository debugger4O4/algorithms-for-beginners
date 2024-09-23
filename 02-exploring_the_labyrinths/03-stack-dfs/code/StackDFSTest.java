import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StackDFSTest {

    @Test
    void test() {
        StackDFS graph = new StackDFS(8);

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
                answer.length == graph.stackDFS(0).length
                && Arrays.equals(answer, graph.stackDFS(0))
        );
        /* graph.getStackDFS(0):
                [0]
                [1, 2, 3]
                [1, 2, 5]
                [1, 2, 4, 6, 7]
                [1, 2, 4, 6]
                [1, 2, 4]
                [1, 2, 1]
                [1, 2]
                [1]
         */
    }
}
