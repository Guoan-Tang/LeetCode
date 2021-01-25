package LeetCode;

import java.util.*;

public class solution102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        List<Integer> temp = new LinkedList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode curNode;
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            temp.clear();
            while (n != 0) {
                n--;
                curNode = queue.pollFirst();
                temp.add(curNode.val);
                if (curNode.left != null) {
                    queue.addLast(curNode.left);
                }
                if (curNode.right != null) {
                    queue.addLast(curNode.right);
                }
            }
            res.add(new ArrayList<>(temp));
        }
        return res;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
