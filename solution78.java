package LeetCode;

import java.util.*;

public class solution78 {
    private List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        List<Integer> temp = new LinkedList<>();
        dfs(nums, 0, temp);
        return res;
    }

    public void dfs(int[] nums, int startIndex, List<Integer> temp) {
        if (startIndex == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[startIndex]);
        dfs(nums, startIndex + 1, temp);
        temp.remove(temp.size() - 1);
        dfs(nums, startIndex + 1, temp);
    }
}
