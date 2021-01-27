

public class solution53 {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        if (nums == null || nums.length < 1) {
            return res;
        }
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (i == j) {
                    dp[j] = nums[i];
                } else {
                    dp[j] = dp[j - 1] + nums[j];
                }
                if (dp[j] > res) {
                    res = dp[j];
                }
            }
        }
        return res;
    }
}