import java.util.*;

public class solution222 {

    private int res = 0;

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int countNodes(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.addLast(root);
        }
        while (!queue.isEmpty()) {
            res++;
            TreeNode cur = queue.pollLast();
            if (cur.left != null) {
                queue.addLast(cur.left);
            }
            if (cur.right != null) {
                queue.addLast(cur.right);
            }
        }
        return res;
    }
}