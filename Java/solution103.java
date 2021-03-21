import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> tempArr = new LinkedList<>();
        if (root == null) {
            return res;
        }
        TreeNode tempNode;
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        boolean reverse = false;
        queue.add(root);
        int count = 1, temp = 0;
        while (!queue.isEmpty()) {
            if (reverse) {
                while (count != 0) {
                    tempNode = queue.pollLast();
                    count--;
                    tempArr.addLast(tempNode.val);
                    if (tempNode.right != null) {
                        queue.addFirst(tempNode.right);
                        temp++;
                    }
                    if (tempNode.left != null) {
                        queue.addFirst(tempNode.left);
                        temp++;
                    }
                }
            } else {
                while (count != 0) {
                    tempNode = queue.pollFirst();
                    count--;
                    tempArr.addLast(tempNode.val);
                    if (tempNode.left != null) {
                        queue.add(tempNode.left);
                        temp++;
                    }
                    if (tempNode.right != null) {
                        queue.add(tempNode.right);
                        temp++;
                    }
                }
            }
            res.add(new ArrayList<>(tempArr));
            tempArr.clear();
            count = temp;
            temp = 0;
            reverse = !reverse;
        }
        return res;
    }
}