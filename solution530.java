

public class solution530 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int pre;
    private int res;

    public int getMinimumDifference(TreeNode root) {
        pre = Integer.MAX_VALUE;
        res = Integer.MAX_VALUE;
        TreeNode temp = root;
        while (temp.left != null) {
            temp = temp.left;
        }
        pre = temp.val - Integer.MAX_VALUE;
        inOrder(root);
        return res;
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if ((root.val - pre) < res) {
            res = root.val - pre;
        }
        pre = root.val;
        inOrder(root.right);
    }
}
