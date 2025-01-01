import java.util.LinkedList;

public class TranspositionSearch {

    // Алгоритм
    public static ListNode1 transpositionSearch(LinkedList<ListNode1> list, String target) {
        ListNode1 previous = null;
        ListNode1 beforePrevious = null;
        for (ListNode1 current : list) {
            if (current.value.equals(target)) {
                if (previous != null) {
                    list.remove(current);
                    addBefore(previous, current);
                }
                return current;
            }
            beforePrevious = previous;
            previous = current;
        }
        return null;
    }

    public static void addBefore(ListNode1 before, ListNode1 node) {
        if (before == null) {
            throw new IllegalArgumentException("Переданный узел не может быть null");
        }
        ListNode1 temp = before.next;
        before.next = node;
        node.next = temp;
    }

    static class ListNode1 {
        String value;
        ListNode1 next;

        public ListNode1(String value) {
            this.value = value;
        }
    }
}
