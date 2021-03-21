public class solution108 {
    private int[] num;

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        this.num = nums;
        return core(0, nums.length - 1);
    }

    public TreeNode core(int l, int r) {
        if (l <= r) {
            int mid = (l + r) / 2;
            TreeNode res = new TreeNode(num[mid]);
            res.left = core(l, mid - 1);
            res.right = core(mid + 1, r);
            return res;
        } else {
            return null;
        }
    }
}
