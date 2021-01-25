package LeetCode;

public class solution141 {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode r = head, l = head;
        for (int i = 0; true; i++) {
            if (r.next == null) {
                return false;
            }
            r = r.next;
            if (r == l) {
                return true;
            }
            if ((i & 1) == 1) {
                l = l.next;
            }
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
