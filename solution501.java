package LeetCode;

import java.util.*;

public class solution501 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        new solution501().inOrderMorris(root);
    }

    private List<Integer> record;
    private int count, num, maxCount;

    public int[] findMode(TreeNode root) {
        record = new LinkedList<Integer>();
        count = maxCount = 1;
        num = Integer.MIN_VALUE;
        inOrderMorris(root);
        return record.stream().mapToInt(i -> i).toArray();
    }

    public void inOrderMorris(TreeNode root) {
        if (root == null) {
            return;
        }
        while (root != null) {
            if (root.left == null) {
                update(root.val);
                root = root.right;
            } else {
                TreeNode preNode = findLeft(root);
                if (preNode.right == root) {
                    preNode.right = null;
                    update(root.val);
                    root = root.right;
                } else {
                    preNode.right = root;
                    root = root.left;
                }
            }
        }
        if (count > maxCount) {
            record.clear();
            record.add(num);
            maxCount = count;
        } else if (count == maxCount) {
            record.add(num);
        }
    }

    public TreeNode findLeft(TreeNode root) {
        TreeNode res = root.left;
        while (res.right != null && res.right != root) {
            res = res.right;
        }
        return res;
    }

    public void update(int val) {
        if (num == Integer.MIN_VALUE) {
            // first number
            num = val;
            count = 1;
            return;
        }
        if (num == val) {
            count++;
        } else {
            // change number
            if (count > maxCount) {
                record.clear();
                record.add(num);
                maxCount = count;
            } else if (count == maxCount) {
                record.add(num);
            }
            num = val;
            count = 1;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}