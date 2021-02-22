public class solutionJ52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node0 = headA, node1 = headB;
        while (node0 != node1) {
            node0 = node0 == null ? headB : node0.next;
            node1 = node1 == null ? headA : node1.next;
        }
        return node0;
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
