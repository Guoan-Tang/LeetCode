package LeetCode;

import java.util.*;

public class solution94 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        inorderTraversalMorris(res, root);
        return res;
    }

    // recursion
    public void inorderTraversalRecursive(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalRecursive(res, root.left);
        res.add(root.val);
        inorderTraversalRecursive(res, root.right);
    }

    public void inorderTraversalIterate(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
    }

    public void inorderTraversalMorris(List<Integer> res, TreeNode root) {
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
                    root = root.left;
                } else {
                    res.add(root.val);
                    preNode.right = null;
                    root = root.right;
                }
            }
        }
    }
}