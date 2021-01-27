

public class solution617 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        synchronize(t1, t2);
        return t1;
    }

    public void synchronize(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) {
            return;
        }
        t1.val += t2.val;
        if (t2.left != null) {
            if (t1.left == null) {
                t1.left = t2.left;
            } else {
                synchronize(t1.left, t2.left);
            }
        }
        if (t2.right != null) {
            if (t1.right == null) {
                t1.right = t2.right;
            } else {
                synchronize(t1.right, t2.right);
            }
        }
    }
}
