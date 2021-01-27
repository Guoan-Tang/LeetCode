

import java.util.LinkedList;
import java.util.List;

public class solution637 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        double temp = 0;
        int count = 0;
        queue.addLast(root);
        queue.addLast(null);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.pollFirst();
            if (currentNode == null) {
                res.add(temp / count);
                temp = 0;
                count = 0;
                if (!queue.isEmpty()) {
                    queue.addLast(null);
                }
            } else {
                temp += currentNode.val;
                count++;
                if (currentNode.left != null) {
                    queue.addLast(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.addLast(currentNode.right);
                }
            }
        }
        return res;
    }
}
