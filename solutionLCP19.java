package LeetCode;

public class solutionLCP19 {
    public int minimumOperations(String leaves) {
        char[] c = leaves.toCharArray();
        int[][] dp = new int[c.length][3];
        if (c[0] == 'y') {
            dp[0][0] = 1;
        }
        dp[0][1] = Integer.MAX_VALUE;
        dp[0][2] = Integer.MAX_VALUE;
        for (int i = 1; i < c.length; i++) {
            if (c[i] == 'y') {
                // cur leave's color is yellow
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = dp[i - 1][0] > dp[i - 1][1] ? dp[i - 1][1] : dp[i - 1][0];
                if (i < 2) {
                    dp[i][2] = Integer.MAX_VALUE;
                } else {
                    dp[i][2] = dp[i - 1][1] > dp[i - 1][2] ? dp[i - 1][2] + 1 : dp[i - 1][1] + 1;
                }
            } else {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][0] > dp[i - 1][1] ? dp[i - 1][1] + 1 : dp[i - 1][0] + 1;
                if (i < 2) {
                    dp[i][2] = Integer.MAX_VALUE;
                } else {
                    dp[i][2] = dp[i - 1][1] > dp[i - 1][2] ? dp[i - 1][2] : dp[i - 1][1];
                }
            }
        }
        return dp[c.length - 1][2];
    }
}
