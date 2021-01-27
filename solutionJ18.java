

public class solutionJ18 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode pre = head, next = head.next, temp;
        while (next != null && next.val != val) {
            temp = next;
            next = next.next;
            pre = temp;
        }
        if (next != null) {
            pre.next = next.next;
        }
        return head;
    }
}
