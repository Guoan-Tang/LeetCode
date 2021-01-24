public class solution85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] left = new int[m][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != '0') {
                    left[i][j] = (j == 0) ? 1 : (left[i][j - 1] + 1);
                }
            }
        }
        int res = 0, width, area;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != '0') {
                    width = left[i][j];
                    area = width;
                    for (int k = i - 1; k >= 0; k--) {
                        width = Math.min(left[k][j], width);
                        area = Math.max((i - k + 1) * width, area);
                    }
                    res = Math.max(area, res);
                }
            }
        }
        return res;
    }
}