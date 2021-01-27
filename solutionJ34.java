

import java.util.LinkedList;
import java.util.List;

public class solutionJ34 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<List<Integer>> ans;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        List<Integer> temp = new LinkedList<>();
        core(root, sum, 0, (LinkedList<Integer>) temp);
        return ans;
    }

    public void core(TreeNode root, int sum, int currentSum, LinkedList<Integer> path) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            // current node is the leaf node
            if (currentSum + root.val == sum) {
                // sum of the path is correct
                LinkedList<Integer> temp = new LinkedList<>(path);
                temp.addLast(root.val);
                ans.add(temp);
                return;
            } else {
                return;
            }
        } else {
            // not arive at the leaf node
            path.addLast(root.val);
            if (root.left != null) {
                core(root.left, sum, currentSum + root.val, path);
            }
            if (root.right != null) {
                core(root.right, sum, currentSum + root.val, path);
            }
            path.removeLast();
        }

    }

    public static void main(String[] args) {

    }
}


