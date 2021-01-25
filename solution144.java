package LeetCode;

import java.util.*;

public class solution144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        preorderTraversalMorris(res, root);
        return res;
    }

    public void preorderTraversalMorris(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        while (root != null) {
            if (root.left == null) {
                res.add(root.val);
                root = root.right;
            } else {
                TreeNode preNode = root.left;
                while (preNode.right != null && preNode.right != root) {
                    preNode = preNode.right;
                }
                if (preNode.right == null) {
                    preNode.right = root;
                    res.add(root.val);
                    root = root.left;
                } else {
                    preNode.right = null;
                    root = root.right;
                }
            }
        }
    }

    public void preorderTraversalIterate(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode curNode;
        queue.addLast(root);
        while (!queue.isEmpty()) {
            curNode = queue.pollLast();
            res.add(curNode.val);
            if (curNode.right != null) {
                queue.addLast(curNode.right);
            }
            if (curNode.left != null) {
                queue.addLast(curNode.left);
            }
        }
    }

    public void preorderTraversalRecursive(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorderTraversalRecursive(res, root.right);
        preorderTraversalRecursive(res, root.left);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
