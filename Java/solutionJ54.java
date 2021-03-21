public class solutionJ54 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int K, res;
    
    public int kthLargest(TreeNode root, int k) {
        K = k;
        recursive(root);
        return res;
    }

    private void recursive(TreeNode root) {
        if (root == null) {
            return;
        }
        recursive(root.right);
        if (K == 0) {
            return;
        }
        if (--K == 0) {
            res = root.val;
            return;
        }
        recursive(root.left);
    }
}
