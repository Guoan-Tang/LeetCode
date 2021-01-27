

import java.util.*;

public class solution145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        postorderTraversalRecursive(res, root);
        return res;
    }

    public void postorderTraversalRecursive(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        postorderTraversalRecursive(res, root.left);
        postorderTraversalRecursive(res, root.right);
        res.add(root.val);
    }

    public void postorderTraversalIterate(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode curNode;
        Deque<Integer> LinkedRes = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            curNode = stack.pop();
            if (curNode.left != null) {
                stack.push(curNode.left);
            }
            if (curNode.right != null) {
                stack.push(curNode.right);
            }
            LinkedRes.addFirst(curNode.val);
        }
        res = new ArrayList<>(LinkedRes);
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
