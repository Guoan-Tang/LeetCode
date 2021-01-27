

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class solution47 {
    private List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new LinkedList<List<Integer>>();
        if (nums == null) {
            return res;
        }
        Arrays.sort(nums);
        ArrayList<Integer> temp = new ArrayList<>(nums.length);
        boolean[] selected = new boolean[nums.length];
        recursion(0, temp, nums, selected);
        return res;
    }

    public void recursion(int length, ArrayList<Integer> temp, int[] nums, boolean[] selected) {
        if (length >= nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (selected[i]) {
                // had selected this number
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !selected[i - 1]) {
                // check if had used the same number
                continue;
            }
            temp.add(nums[i]);
            selected[i] = true;
            recursion(length + 1, temp, nums, selected);
            temp.remove(temp.size() - 1);
            selected[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] test = { 1, 1, 2 };
        System.out.println(new solution47().permuteUnique(test));
    }
}
