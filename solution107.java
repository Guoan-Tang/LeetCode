import java.util.*;

public class solution107 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return new ArrayList<>(res);
        }
        LinkedList<Integer> temp = new LinkedList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode cur;
        queue.add(root);
        int count = 1;
        while (!queue.isEmpty()) {
            while (count != 0) {
                cur = queue.pollFirst();
                if (cur.left != null) {
                    queue.addLast(cur.left);
                }
                if (cur.right != null) {
                    queue.addLast(cur.right);
                }
                temp.add(cur.val);
                count--;
            }
            count = queue.size();
            res.addFirst(new ArrayList<>(temp));
            temp.clear();
        }
        return new ArrayList<>(res);
    }
}
