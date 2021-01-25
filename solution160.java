package LeetCode;

public class solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // move both two pointers in sync
        ListNode pointerA = headA, pointerB = headB, lastNode = null;
        while (pointerA != pointerB) {
            if (pointerA.next == null) {
                if (lastNode == null) {
                    lastNode = pointerA;
                    pointerA = headB;
                } else {
                    if (lastNode == pointerA) {
                        pointerA = headB;
                    } else {
                        return null;
                    }
                }
            } else {
                pointerA = pointerA.next;
            }
            if (pointerB.next == null) {
                if (lastNode == null) {
                    lastNode = pointerB;
                    pointerB = headA;
                } else {
                    if (lastNode == pointerB) {
                        pointerB = headA;
                    } else {
                        return null;
                    }
                }
            } else {
                pointerB = pointerB.next;
            }
        }
        return pointerA;
    }
}
