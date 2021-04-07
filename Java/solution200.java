public class solution200 {
    private char[][] grids;
    private boolean[][] hadCount;
    private int res;

    public int numIslands(char[][] grid) {
        grids = grid;
        hadCount = new boolean[grid.length][grid[0].length];
        res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!hadCount[i][j] && grids[i][j] == '1') {
                    res++;
                    recursive(i, j);
                }
            }
        }
        return res;
    }

    private void recursive(int row, int col) {
        if (row >= grids.length || row < 0) {
            return;
        }
        if (col >= grids[0].length || col < 0) {
            return;
        }
        if (hadCount[row][col]) {
            return;
        }
        hadCount[row][col] = true;
        if (grids[row][col] == '0') {
            return;
        }
        recursive(row + 1, col);
        recursive(row - 1, col);
        recursive(row, col + 1);
        recursive(row, col - 1);
    }
}