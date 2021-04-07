public class solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] sc1 = text1.toCharArray(), sc2 = text2.toCharArray();
        int[][] dp = new int[sc1.length][sc2.length];
        if (sc1[0] == sc2[0]) {
            dp[0][0] = 1;
        } else {
            dp[0][0] = 0;
        }
        for (int i = 1; i < sc1.length; i++) {
            if (dp[i - 1][0] == 1) {
                dp[i][0] = 1;
            } else if (sc1[i] == sc2[0]) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = 0;
            }
        }
        for (int i = 1; i < sc2.length; i++) {
            if (dp[0][i - 1] == 1) {
                dp[0][i] = 1;
            } else if (sc1[0] == sc2[i]) {
                dp[0][i] = 1;
            } else {
                dp[0][i] = 0;
            }
        }
        for (int i = 1; i < sc1.length; i++) {
            for (int j = 1; j < sc2.length; j++) {
                if (sc1[i] == sc2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[sc1.length - 1][sc2.length - 1];
    }
}
