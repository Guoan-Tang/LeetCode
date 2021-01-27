

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class solutionJ32_1 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> res = new LinkedList<>();
        Deque<TreeNode> tempDeque = new LinkedList<>();
        tempDeque.push(root);
        while (!tempDeque.isEmpty()) {
            TreeNode tempNode = tempDeque.pollLast();
            res.add(tempNode.val);
            if (tempNode.left != null) {
                tempDeque.push(tempNode.left);
            }
            if (tempNode.right != null) {
                tempDeque.push(tempNode.right);
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
