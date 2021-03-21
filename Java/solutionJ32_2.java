

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class solutionJ32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList<List<Integer>>();
        }
        Deque<TreeNode> nodeDeque = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        nodeDeque.push(root);
        int curRow = 1, nextRow = 0;
        List<Integer> listTemp = new LinkedList<>();
        while (!nodeDeque.isEmpty()) {
            TreeNode nodeTemp = nodeDeque.pollLast();
            // while node queue is not empty
            if (curRow != 0) {
                // there are still nodes in current row
                listTemp.add(nodeTemp.val);
                if (nodeTemp.left != null) {
                    nextRow++;
                    nodeDeque.push(nodeTemp.left);
                }
                if (nodeTemp.right != null) {
                    nextRow++;
                    nodeDeque.push(nodeTemp.right);
                }
                curRow--;
            } else {
                // switch to next row
                curRow = nextRow;
                nextRow = 0;
                res.add(listTemp);
                listTemp = new LinkedList<>();
                listTemp.add(nodeTemp.val);
                if (nodeTemp.left != null) {
                    nextRow++;
                    nodeDeque.push(nodeTemp.left);
                }
                if (nodeTemp.right != null) {
                    nextRow++;
                    nodeDeque.push(nodeTemp.right);
                }
                curRow--;
            }
        }
        if (curRow == 0 && nextRow == 0) {
            res.add(listTemp);
        }
        return res;
    }
}