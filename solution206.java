package LeetCode;

public class solution206 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // ***********************recursion****************************** */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode temp = head.next;
        head.next = null;
        return recursion(head, temp);
    }

    public ListNode recursion(ListNode pre, ListNode next) {
        if (next == null) {
            return pre;
        }
        ListNode temp = next.next;
        next.next = pre;
        return recursion(next, temp);
    }

    // **********************iteration****************************** */
    // public ListNode reverseList(ListNode head) {
    // if (head == null) {
    // return head;
    // }
    // ListNode pre = head, cur = pre.next, next = null;
    // head.next = null;
    // if (cur != null) {
    // next = cur.next;
    // }
    // while (cur != null) {
    // cur.next = pre;
    // pre = cur;
    // cur = next;
    // if (next != null) {
    // next = next.next;
    // } else {
    // next = null;
    // }
    // }

    // return pre;
    // }
}
