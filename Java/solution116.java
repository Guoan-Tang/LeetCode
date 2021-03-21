

import java.util.*;

public class solution116 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        List<List<Node>> layers = new LinkedList<>();
        List<Node> temp = new LinkedList<Node>();
        Deque<Node> queue = new LinkedList<>();
        Node curNode, preNode = null;
        int cur = 1, next = 0;
        queue.addLast(root);
        while (!queue.isEmpty()) {
            while (cur != 0) {
                cur--;
                curNode = queue.pollFirst();
                temp.add(curNode);
                if (curNode.left != null) {
                    queue.addLast(curNode.left);
                    next++;
                }
                if (curNode.right != null) {
                    queue.addLast(curNode.right);
                    next++;
                }
            }
            layers.add(new ArrayList<>(temp));
            temp.clear();
            cur = next;
            next = 0;
        }
        for (List<Node> curLayer : layers) {
            for (int i = curLayer.size() - 1; i >= 0; i--) {
                curNode = curLayer.get(i);
                if (i == curLayer.size() - 1) {
                    curNode.next = null;
                } else {
                    curNode.next = preNode;
                }
                preNode = curNode;
            }
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
