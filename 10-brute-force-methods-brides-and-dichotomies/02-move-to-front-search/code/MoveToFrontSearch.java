import java.util.LinkedList;

public class MoveToFrontSearch {

    // Алгоритм
    public static ListNode moveToFrontSearch(LinkedList<ListNode> list, String target) {
        ListNode previous = null;
        for (ListNode current : list) {
            if (current.value.equals(target)) {
                if (previous != null) {
                    list.remove(current);
                    list.addFirst(current);
                }
                return current;
            }
            previous = current;
        }
        return null;
    }

    static class ListNode {
        String value;
        ListNode next;

        public ListNode(String value) {
            this.value = value;
        }
    }
}
