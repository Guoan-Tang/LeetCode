public class solutionJ55_2 {
    private boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int l = depth(root.left, 0), r = depth(root.right, 0);
        if (Math.abs(l - r) > 1) {
            return false;
        }
        if (!flag) {
            return false;
        }
        return true;
    }

    private int depth(TreeNode root, int d) {
        if (root == null) {
            return d;
        }
        int l = depth(root.left, d + 1), r = depth(root.right, d + 1);
        if (Math.abs(l - r) > 1) {
            flag = false;
        }
        return Math.max(l, r);
    }
}
