

public class solution236 {
    private TreeNode res;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean leftSubHadNode = dfs(root.left, p, q), rightSubHadNode = dfs(root.right, p, q);
        // current node is the lowest common node
        if ((leftSubHadNode && rightSubHadNode)
                || ((root.val == p.val || root.val == q.val) && (leftSubHadNode || rightSubHadNode))) {
            res = root;
        }
        // if had one of two node
        return leftSubHadNode || rightSubHadNode || root.val == p.val || root.val == q.val;
    }
}
