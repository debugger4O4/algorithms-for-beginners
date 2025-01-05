import org.junit.Test;

import java.util.ArrayList;

public class CreateRtOccurrencesTableTest {

    @Test
    public void test() {
        String p = "hello world";
        String t = "hello world";
        int s = 26;
        ArrayList<Integer> rt = CreateRtOccurrencesTable.createRtOccurrencesTable(p, t, s);
        System.out.println("Созданная таблица: " + rt);
    }
}
