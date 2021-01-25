package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length < 3) {
            return res;
        }
        quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int k = nums.length - 1;
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    // skip the nums[j] if it euqals to the pre num
                    continue;
                }
                if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] < 0) {
                    break;
                }
                while (j < k && nums[i] + nums[j] + nums[k] > 0) {
                    // too large for zero
                    // decrease third num
                    k--;
                }
                if (j == k) {
                    break;
                }
                if (nums[i] + nums[j] + nums[k] == 0) {
                    // match
                    List<Integer> temp = new LinkedList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    res.add(temp);
                }
            }
        }
        return res;
    }

    public void quickSort(int[] num, int left, int right) {
        if (left < right) {
            int pivotpos = partition(num, left, right);
            quickSort(num, left, pivotpos - 1);
            quickSort(num, pivotpos + 1, right);
        }
    }

    public int partition(int[] num, int leftP, int rightP) {
        int pivot = num[leftP], pivotPos = leftP, right = leftP + 1;
        while (right <= rightP) {
            if (num[right] < pivot) {
                pivotPos++;
                if (pivotPos != right) {
                    int temp = num[pivotPos];
                    num[pivotPos] = num[right];
                    num[right] = temp;
                }
            }
            right++;
        }
        num[leftP] = num[pivotPos];
        num[pivotPos] = pivot;
        return pivotPos;
    }

    public static void main(String[] args) {
        System.out.print(new solution15().threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
    }
}
