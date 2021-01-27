


public class solution105 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length < 1) {
            return null;
        }
        return core(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode core(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft,
            int inRight) {
        if (preLeft == preRight) {
            return new TreeNode(preorder[preLeft]);
        }
        if (preLeft > preRight || inLeft > inRight || preLeft >= preorder.length || preRight < 0
                || inLeft >= inorder.length || inRight < 0) {
            return null;
        }
        TreeNode res = new TreeNode(preorder[preLeft]);
        int mid = inLeft;
        for (int i = inLeft; i <= inRight; i++) {
            if (preorder[preLeft] == inorder[i]) {
                mid = i;
                break;
            }
        }
        res.left = core(preorder, inorder, preLeft + 1, preRight - inRight + mid, inLeft, mid - 1);
        res.right =
                core(preorder, inorder, preRight - inRight + mid + 1, preRight, mid + 1, inRight);
        return res;
    }

    public static void main(String[] args){
        int[] a={1,2},b={2,1};
        System.out.print(new solution105().buildTree(a,b));
    }
}
