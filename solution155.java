

public class solution155 {
    class MinStack {
        Node head;

        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int x) {
            if (head == null) {
                head = new Node(x, x, null);
            } else {
                head = new Node(x, Math.min(x, getMin()), head);
            }
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }

        class Node {
            int val;
            int min;
            Node next;

            public Node(int a, int b, Node c) {
                val = a;
                min = b;
                next = c;
            }
        }
    }
}
