

public class solution300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = 1;
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxLength = 0;
            for (int j = i - 1; j >= maxLength; j--) {
                if (nums[j] <= nums[i]) {
                    maxLength = dp[j] > maxLength ? dp[j] : maxLength;
                }
            }
            dp[i] = maxLength + 1;
            res = dp[i] > res ? dp[i] : res;
        }
        return res;
    }
}
