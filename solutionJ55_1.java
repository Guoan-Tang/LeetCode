public class solutionJ55_1 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int count) {
        if (root == null) {
            return count;
        }
        return Math.max(dfs(root.left, count + 1), dfs(root.right, count + 1));
    }
}
