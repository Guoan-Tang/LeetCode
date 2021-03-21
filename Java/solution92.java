public class solution92 {
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverse(head, right - left + 1);
        } else {
            int cur = 1;
            ListNode curNode = head, preNode = head;
            while (cur < left) {
                cur++;
                preNode = curNode;
                curNode = curNode.next;
            }
            preNode.next = reverse(curNode, right - left + 1);
            return head;
        }
    }

    private ListNode reverse(ListNode head, int count) {
        if (head == null || head.next == null || count < 2) {
            return head;
        }
        ListNode curNode = head.next, preNode = head, temp = curNode.next;
        while (count > 2) {
            curNode.next = preNode;
            preNode = curNode;
            curNode = temp;
            temp = curNode.next;
            count--;
        }
        curNode.next = preNode;
        head.next = temp;
        return curNode;
    }
}