

public class solution104 {
    private int res;

    public int maxDepth(TreeNode root) {
        res = 0;
        dfs(0, root);
        return res;
    }

    public void dfs(int count, TreeNode root) {
        if (root == null) {
            if (count > res) {
                res = count;
            }
            return;
        }
        dfs(count + 1, root.left);
        dfs(count + 1, root.right);
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
