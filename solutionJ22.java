package LeetCode;

public class solutionJianZhiOffer22 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode left = head, right;
        while (k != 0 && left != null) {
            left = left.next;
            k--;
        }
        if (left == null) {
            return head;
        }
        right = head;

        while (left != null) {
            left = left.next;
            right = right.next;
        }

        return right;
    }
}
