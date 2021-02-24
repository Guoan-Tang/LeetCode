public class solution832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int rowSize = A[0].length;
        int[][] res = new int[A.length][rowSize];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                res[i][rowSize - 1 - j] = 1 ^ A[i][j];
            }
        }
        return res;
    }
}