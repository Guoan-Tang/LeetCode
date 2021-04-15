public class solution72 {
    public int minDistance(String word1, String word2) {
        char[] sc1 = word1.toCharArray(), sc2 = word2.toCharArray();
        int[][] dp = new int[sc1.length + 1][sc2.length + 1];
        for (int i = 1; i < sc1.length + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < sc2.length + 1; i++) {
            dp[0][i] =i;
        }
        for (int i = 1; i < sc1.length + 1; i++) {
            for (int j = 1; j < sc2.length + 1; j++) {
                if (sc1[i - 1] == sc2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[sc1.length][sc2.length];
    }
}
