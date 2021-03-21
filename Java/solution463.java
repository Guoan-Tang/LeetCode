public class solution463 {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    res += 4;
                    if (haddown(i, j, grid)) {
                        res--;
                    }
                    if (hadup(i, j, grid)) {
                        res--;
                    }
                    if (hadleft(i, j, grid)) {
                        res--;
                    }
                    if (hadright(i, j, grid)) {
                        res--;
                    }
                }
            }
        }
        return res;
    }

    public boolean hadup(int x, int y, int[][] grid) {
        if (x == 0) {
            return false;
        }
        if (grid[x - 1][y] == 1) {
            return true;
        }
        return false;
    }

    public boolean haddown(int x, int y, int[][] grid) {
        if (x == grid.length - 1) {
            return false;
        }
        if (grid[x + 1][y] == 1) {
            return true;
        }
        return false;
    }

    public boolean hadleft(int x, int y, int[][] grid) {
        if (y == 0) {
            return false;
        }
        if (grid[x][y - 1] == 1) {
            return true;
        }
        return false;
    }

    public boolean hadright(int x, int y, int[][] grid) {
        if (y == grid[0].length - 1) {
            return false;
        }
        if (grid[x][y + 1] == 1) {
            return true;
        }
        return false;
    }
}
