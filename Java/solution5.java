public class solution5 {
    public String longestPalindrome(String s) {
        // dynamic programming language
        if (s.length() < 2) {
            return s;
        }
        char[] sc = s.toCharArray();
        int lr = 0, rr = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < dp.length - 1; i++) {
            dp[i][i] = true;
            if (sc[i] == sc[i + 1]) {
                dp[i][i + 1] = true;
                lr = i;
                rr = i + 1;
            }
        }
        dp[dp.length - 1][dp.length - 1] = true;
        for (int len = 3; len <= sc.length; len++) {
            for (int l = 0; l < sc.length; l++) {
                if (l + len - 1 >= sc.length) {
                    break;
                }
                if (dp[l + 1][l + len - 2] && sc[l] == sc[l + len - 1]) {
                    dp[l][l + len - 1] = true;
                    if (len > rr - lr + 1) {
                        lr = l;
                        rr = l + len - 1;
                    }
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while (lr <= rr) {
            res.append(sc[lr]);
            lr++;
        }
        return res.toString();
    }
}
