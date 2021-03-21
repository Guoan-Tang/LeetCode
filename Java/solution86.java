class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class solution86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode larHead = null, larCur = null, minHead = null, minCur = null;
        while (head != null) {
            if (head.val >= x) {
                if (larHead == null) {
                    larHead = head;
                } else {
                    larCur.next = head;
                }
                larCur = head;
            } else {
                if (minHead == null) {
                    minHead = head;
                } else {
                    minCur.next = head;
                }
                minCur = head;
            }
            head = head.next;
        }
        if (larCur != null) {
            larCur.next = null;
        }
        if (minCur != null) {
            minCur.next = larHead;
            return minHead;
        } else {
            return larHead;
        }
    }
}