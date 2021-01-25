package LeetCode;

public class solution416 {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i : nums) {
            sum += i;
            if (i > max) {
                max = i;
            }
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum >> 1;
        if (max > target) {
            return false;
        }
        if (max == target) {
            return true;
        }
        boolean[][] dp = new boolean[nums.length][target + 1];
        dp[0][nums[0]] = true;
        dp[0][0] = true;
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = true;
            for (int j = 1; j < target + 1; j++) {
                if (dp[i - 1][j] || (j - nums[i] >= 0 && dp[i - 1][j - nums[i]])) {
                    dp[i][j] = true;
                }
            }
            if (dp[i][target]) {
                return true;
            }
        }
        return false;
    }
}