

public class solution10 {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j == 0) {
                    if (i == 0) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    // when j is not zero
                    if (p.charAt(j - 1) == '*') {
                        // current char in pattern is *
                        if (j >= 2 && dp[i][j - 2]) {
                            // ignore pre char and *
                            dp[i][j] = true;
                        } else if (i >= 1 && j >= 2 && dp[i - 1][j]
                                && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                            // char before * is matched
                            dp[i][j] = true;
                        }
                    } else if (p.charAt(j - 1) == '.') {
                        // current char is .
                        if (i >= 1 && j >= 1) {
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    } else {
                        if (i >= 1 && j >= 1 && s.charAt(i - 1) == p.charAt(j - 1)) {
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    }
                }
            }
        }
        return dp[m][n];
    }
}
