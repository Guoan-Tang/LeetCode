package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class solution23 {
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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode n1, ListNode n2) {
                if (n1.val == n2.val) {
                    return 0;
                }
                return n1.val > n2.val ? 1 : -1;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                queue.add(lists[i]);
        }
        if (queue.isEmpty()) {
            return null;
        }
        ListNode res = queue.poll(), temp = res;
        if (temp.next != null) {
            queue.add(temp.next);
        }
        while (!queue.isEmpty()) {
            temp.next = queue.poll();
            temp = temp.next;
            if (temp.next != null) {
                queue.add(temp.next);
            }
        }
        return res;
    }
}