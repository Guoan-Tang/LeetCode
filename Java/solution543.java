public class solution543 {
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

    private int res;

    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        findDepth(root);
        if (res == 0) {
            return 0;
        }
        return res - 1;
    }

    private int findDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = findDepth(root.left), rightDepth = findDepth(root.right);
        if (res < leftDepth + rightDepth + 1) {
            res = leftDepth + rightDepth + 1;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
