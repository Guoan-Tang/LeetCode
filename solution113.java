package LeetCode;

import java.util.*;

public class solution113 {
    private List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new LinkedList<>();
        recursive(root, new LinkedList<>(), sum);
        return res;
    }

    public void recursive(TreeNode root, List<Integer> path, int target) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && root.val == target) {
            path.add(root.val);
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        path.add(root.val);
        recursive(root.left, path, target - root.val);
        recursive(root.right, path, target - root.val);
        path.remove(path.size() - 1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
