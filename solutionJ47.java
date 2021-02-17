public class solutionJ47 {
    public int maxValue(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        if (dp[0].length > 1) {
            for (int i = 1; i < dp[0].length; i++) {
                dp[0][i] = dp[0][i - 1] + grid[0][i];
            }
        } else {
            int res = 0;
            for (int i = 0; i < grid.length; i++) {
                res += grid[i][0];
            }
            return res;
        }
        if (dp.length > 1) {
            for (int i = 1; i < dp.length; i++) {
                dp[i][0] = dp[i][i - 1] + grid[i][0];
            }
        } else {
            int res = 0;
            for (int i = 0; i < grid[0].length; i++) {
                res += grid[0][i];
            }
            return res;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
