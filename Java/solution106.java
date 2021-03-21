

public class solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
            return null;
        }
        return recursive(inorder, postorder, 0, inorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode recursive(int[] inorder, int[] postorder, int iL, int iR, int pL, int pR) {
        if (iL == iR) {
            return new TreeNode(inorder[iL]);
        }
        if (iL > iR) {
            return null;
        }
        int mid = iL;
        for (; inorder[mid] != postorder[pR]; mid++) {

        }
        TreeNode res = new TreeNode(inorder[mid]);
        res.left = recursive(inorder, postorder, iL, mid - 1, pL, pL + mid - iL - 1);
        res.right = recursive(inorder, postorder, mid + 1, iR, pL + mid - iL, pR - 1);
        return res;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
