

public class solution1594 {
    public int maxProductPath(int[][] grid) {
        long[][] max = new long[grid.length][grid[0].length], min = new long[grid.length][grid[0].length];
        max[0][0] = grid[0][0];
        min[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            max[i][0] = grid[i][0] * max[i - 1][0];
            min[i][0] = grid[i][0] * min[i - 1][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            max[0][i] = max[0][i - 1] * grid[0][i];
            min[0][i] = min[0][i - 1] * grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                max[i][j] = max(grid[i][j] * max[i - 1][j], grid[i][j] * max[i][j - 1], grid[i][j] * min[i - 1][j],
                        grid[i][j] * min[i][j - 1]);
                min[i][j] = min(grid[i][j] * max[i - 1][j], grid[i][j] * max[i][j - 1], grid[i][j] * min[i - 1][j],
                        grid[i][j] * min[i][j - 1]);
            }
        }
        return max[grid.length - 1][grid[0].length - 1] >= 0
                ? (int) (max[grid.length - 1][grid[0].length - 1] % (1e9 + 7))
                : -1;
    }

    public long max(long a, long b, long c, long d) {
        if (b > a) {
            a = b;
        }
        if (c > a) {
            a = c;
        }
        if (d > a) {
            a = d;
        }
        return a;
    }

    public long min(long a, long b, long c, long d) {
        if (b < a) {
            a = b;
        }
        if (c < a) {
            a = c;
        }
        if (d < a) {
            a = d;
        }
        return a;
    }
}