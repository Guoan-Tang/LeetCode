



public class solution54 {
    private int index = 0;

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length < 1 || matrix[0].length < 1) {
            return new int[0];
        }
        int startIndex = 0, rows = matrix.length, cols = matrix[0].length;
        int[] res = new int[rows * cols];
        if (rows < 1 || cols < 1) {
            return res;
        }
        while (startIndex * 2 < rows && startIndex * 2 < cols) {
            addNum(rows, cols, startIndex, res, matrix);
            startIndex++;
        }
        return res;
    }

    public void addNum(int rows, int cols, int startIndex, int[] res, int[][] matrix) {
        int endX = rows - 1 - startIndex, endY = cols - 1 - startIndex;

        // from left to right
        for (int i = startIndex; i <= endY; i++) {
            res[index++] = matrix[startIndex][i];
        }

        // from top to bottom
        if (startIndex < endX) {
            for (int i = startIndex + 1; i <= endX; i++) {
                res[index++] = matrix[i][endY];
            }
        }


        // from right to left
        if (startIndex < endX && startIndex < endY) {
            for (int i = endY - 1; i >= startIndex; i--) {
                res[index++] = matrix[endX][i];
            }
        }


        // from bottom to top
        if (startIndex < endY && startIndex < endX - 1) {
            for (int i = endX - 1; i > startIndex; i--) {
                res[index++] = matrix[i][startIndex];
            }
        }
    }
}
