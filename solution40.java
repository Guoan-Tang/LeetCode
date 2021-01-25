package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class solution40 {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        if (candidates.length < 1) {
            return res;
        }
        sort(candidates, 0, candidates.length - 1);
        dfs(new LinkedList<>(), candidates, 0, target);
        return res;
    }

    public void dfs(List<Integer> path, int[] candidates, int startIndex, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (startIndex >= candidates.length) {
            return;
        }
        for (int i = startIndex; i < candidates.length; i = noRepetition(candidates, i)) {
            if (candidates[i] > target) {
                return;
            }
            path.add(candidates[i]);
            dfs(path, candidates, i + 1, target - candidates[i]);
            path.remove(path.size() - 1);
        }
    }

    public int noRepetition(int[] nums, int startIndex) {
        int res = startIndex + 1;
        while (res < nums.length && nums[res] == nums[startIndex]) {
            res++;
        }
        return res;
    }

    public void sort(int[] nums, int l, int r) {
        if (l < r) {
            int mid = partition(nums, l, r);
            sort(nums, l, mid - 1);
            sort(nums, mid + 1, r);
        }
    }

    public int partition(int[] nums, int l, int r) {
        int pivot = nums[l], pivotPos = l, index = l + 1;
        while (index <= r) {
            if (nums[index] < pivot) {
                pivotPos++;
                if (pivotPos != index) {
                    int temp = nums[pivotPos];
                    nums[pivotPos] = nums[index];
                    nums[index] = temp;
                }
            }
            index++;
        }
        nums[l] = nums[pivotPos];
        nums[pivotPos] = pivot;
        return pivotPos;
    }
}
