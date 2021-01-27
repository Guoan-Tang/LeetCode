

public class solution19 {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = new ListNode(), fast = first, slow = first;
        first.next = head;
        while (n != 0 && fast != null) {
            fast = fast.next;
            n--;
        }
        if (fast == null) {
            return head;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        if (slow.next == head) {
            return head.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
