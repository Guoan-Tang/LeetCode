package LeetCode;

public class solution138 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node temp = head, next;
        // copy node linked behind the source node
        while (temp != null) {
            next = temp.next;
            temp.next = new Node(temp.val);
            temp.next.next = next;
            temp = next;
        }

        temp = head;
        // initialize copy node's random point
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        Node res = head.next, sourceTemp = head;
        temp = res;
        while (sourceTemp != null) {
            if (sourceTemp.next != null) {
                sourceTemp.next = sourceTemp.next.next;
            }
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
            sourceTemp = sourceTemp.next;
            temp = temp.next;
        }
        
        return res;
    }

}


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
