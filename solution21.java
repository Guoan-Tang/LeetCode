package LeetCode;

public class solution21 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode res = null, resT;
        if (l1.val > l2.val) {
            res = l2;
            l2 = l2.next;
        } else {
            res = l1;
            l1 = l1.next;
        }
        resT = res;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                res.next = l2;
                res = res.next;
                l2 = l2.next;
            } else {
                res.next = l1;
                res = res.next;
                l1 = l1.next;
            }
        }
        if (l1 != null) {
            res.next = l1;
        }
        if (l2 != null) {
            res.next = l2;
        }
        return resT;
    }

    public static void main(String[] args) {
        solution21 temp = new solution21();
        ListNode a = temp.new ListNode(1), tempNode;
        a.next = temp.new ListNode(2);
        tempNode = a.next;
        tempNode.next = temp.new ListNode(4);
        ListNode b = temp.new ListNode(1);
        b.next = temp.new ListNode(3);
        tempNode = b.next;
        tempNode.next = temp.new ListNode(4);
        tempNode = temp.mergeTwoLists(a, b);
        while (tempNode != null) {
            System.out.println(tempNode.val);
            tempNode = tempNode.next;
        }
    }
}
