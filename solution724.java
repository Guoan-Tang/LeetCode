public class solution724 {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int sum = 0, preSum = 0;
        for (int i : nums) {
            sum += i;
        }
        for (int i = 0; i < nums.length; i++) {
            if (sum - nums[i] - 2 * preSum == 0) {
                return i;
            }
            preSum += nums[i];
        }
        return -1;
    }
}
