public class solution61 {
    public class ListNode {
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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int totalCount = 1;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            totalCount++;
        }
        cur.next = head;
        k %= totalCount;
        k = totalCount - k;
        cur = head;
        while (k != 1) {
            cur = cur.next;
            k--;
        }
        head = cur.next;
        cur.next = null;
        return head;
    }
}
