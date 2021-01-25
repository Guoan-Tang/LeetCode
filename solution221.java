package LeetCode;

public class solution221 {
    public static void main(String[] args) {
        char[][] testIn = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' } };
        new solution221().maximalSquare(testIn);
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    if (i + 1 < matrix.length && j + 1 < matrix[0].length && dp[i + 1][j + 1] != 0) {
                        int len = dp[i + 1][j + 1], count = 1;
                        for (; count <= len; count++) {
                            if ((i + count) >= matrix.length || (j + count) >= matrix[0].length
                                    || matrix[i + count][j] != '1' || matrix[i][j + count] != '1') {
                                break;
                            }
                        }
                        dp[i][j] = count;
                    } else {
                        dp[i][j] = 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
                if (dp[i][j] > res) {
                    res = dp[i][j];
                }
            }
        }
        return res * res;
    }
}
