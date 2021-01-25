package LeetCode;

public class solutionJianZhiOffer13 {
    private boolean[][] hadVisited;
    private int result;

    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        hadVisited = new boolean[m][n];
        result = 0;
        visit(m, n, 0, 0, k);
        return result;
    }

    public void visit(int m, int n, int i, int j, int k) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if (hadVisited[i][j]) {
            return;
        }
        if (limit(i, j, k)) {
            return;
        }
        hadVisited[i][j] = true;
        result++;
        visit(m, n, i + 1, j, k);
        visit(m, n, i - 1, j, k);
        visit(m, n, i, j + 1, k);
        visit(m, n, i, j - 1, k);
    }

    public boolean limit(int i, int j, int k) {
        int temp = 0;
        while (i != 0) {
            temp += (i % 10);
            i /= 10;
        }
        while (j != 0) {
            temp += (j % 10);
            j /= 10;
        }
        return temp > k;
    }
}
