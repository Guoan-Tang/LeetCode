package LeetCode;

public class solution142 {
    public ListNode detectCycle(ListNode head) {
        // find the node where fast pointer meet slow pointer
        ListNode slow = head, fast;
        if (slow == null) {
            return null;
        } else {
            fast = slow.next;
        }
        if (fast == null) {
            return null;
        } else {
            fast = fast.next;
        }
        slow = slow.next;
        while (fast != slow) {
            if (fast == null) {
                return null;
            } else {
                fast = fast.next;
            }
            if (fast == null) {
                return null;
            } else {
                fast = fast.next;
            }
            slow = slow.next;
        }

        // restart form the head to find the entrance of ring
        while (head != fast) {
            head = head.next;
            fast = fast.next;
        }
        return head;
    }
}
