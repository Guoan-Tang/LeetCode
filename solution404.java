package LeetCode;

public class solution404 {
    private int res = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root, false);
        return res;
    }

    public void dfs(TreeNode root, boolean isLeft) {
        if (root == null) {
            return;
        }
        if (isLeft && root.left == null && root.right == null) {
            res += root.val;
        }
        dfs(root.left, true);
        dfs(root.right, false);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}