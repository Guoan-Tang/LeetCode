public class solutionJ60 {
    public double[] dicesProbability(int n) {
        int[][] dp = new int[n][6 * n];
        for (int i = 0; i < 6; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            // 第 i + 1 个骰子
            // 投递 i + 1 个骰子产生的点数和的范围是 [i + 1, 6 * (i + 1)]
            for (int j = i; j < 6 * (i + 1); j++) {
                for (int k = 1; k < 7; k++) {
                    if (j - k >= 0) {
                        dp[i][j] += dp[i - 1][j - k];
                    }
                }
            }
        }
        double sum = Math.pow(6, n);
        double[] res = new double[5 * n + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = dp[n - 1][n + i - 1] / sum;
        }
        return res;
    }
}
