public class solutionJ57 {
    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] == target - nums[r]) {
                break;
            } else if (nums[l] < target - nums[r]) {
                l++;
            } else {
                r--;
            }
        }
        if (l < r) {
            return new int[]{nums[l], nums[r]};
        }
        return new int[0];
    }
}
