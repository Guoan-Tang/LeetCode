public class solutionJ26 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return findHead(A, B);
    }

    public boolean findHead(TreeNode A, TreeNode B) {
        if (B == null || A == null) {
            return false;
        }
        if (A.val == B.val) {
            if (findBody(A.left, B.left) && findBody(A.right, B.right)) {
                return true;
            } else {
                return findHead(A.left, B) || findHead(A.right, B);
            }
        } else {
            return findHead(A.left, B) || findHead(A.right, B);
        }
    }

    public boolean findBody(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        if (A.val == B.val) {
            return findBody(A.left, B.left) && findBody(A.right, B.right);
        } else {
            return false;
        }
    }

    public boolean core(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        if (A.val == B.val) {
            return core(A.left, B.left) || core(A.right, B.right);
        } else {
            return core(A.left, B) || core(A.right, B);
        }
    }

    public static void main(String[] args) {
    }
}
