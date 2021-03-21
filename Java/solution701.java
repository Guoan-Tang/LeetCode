

public class solution701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        TreeNode temp = root;
        while (temp.val != val) {
            if (temp.val > val) {
                if (temp.left != null) {
                    temp = temp.left;
                } else {
                    break;
                }
            } else {
                if (temp.right != null) {
                    temp = temp.right;
                } else {
                    break;
                }
            }
        }
        if (temp.val == val) {
            TreeNode insertNode = new TreeNode(val);
            insertNode.left = temp.left;
            temp.left = insertNode;
        } else if (temp.val > val) {
            temp.left = new TreeNode(val);
        } else {
            temp.right = new TreeNode(val);
        }
        return root;
    }

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
}
