package LeetCode;

import java.util.*;

public class solution199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> levels = new LinkedList<>();
        if (root == null) {
            return new LinkedList<Integer>();
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        int size;
        LinkedList<Integer> temp = new LinkedList<>();
        while (!queue.isEmpty()) {
            size = queue.size();
            temp.clear();
            while (size != 0) {
                size--;
                TreeNode curNode = queue.pollFirst();
                if (curNode.left != null) {
                    queue.addLast(curNode.left);
                }
                if (curNode.right != null) {
                    queue.addLast(curNode.right);
                }
                temp.add(curNode.val);
            }
            levels.add(new ArrayList<>(temp));
        }
        List<Integer> res = new ArrayList<>(levels.size());
        for (List<Integer> tempList : levels) {
            res.add(tempList.get(tempList.size() - 1));
        }
        return res;
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
