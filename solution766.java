public class solution766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 1; j < matrix.length && i + j < matrix[0].length; j++) {
                if (matrix[0][i] != matrix[j][i + j]) {
                    return false;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; i + j < matrix.length && j < matrix[0].length; j++) {
                if (matrix[i][0] != matrix[i + j][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
