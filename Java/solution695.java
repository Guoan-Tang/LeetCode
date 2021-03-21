



public class solution695 {
    private boolean[][] hadVisted;
    private int[][] map;
    private int res, count;

    public int maxAreaOfIsland(int[][] grid) {
        hadVisted = new boolean[grid.length][grid[0].length];
        map = grid;
        count = 0;
        res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!hadVisted[i][j] && map[i][j] == 1) {
                    visit(i, j);
                }
            }
        }
        return res;
    }

    public void visit(int i, int j) {
        count++;
        hadVisted[i][j] = true;
        visitBody(i + 1, j);
        visitBody(i - 1, j);
        visitBody(i, j + 1);
        visitBody(i, j - 1);
        if (count > res) {
            res = count;
        }
        count = 0;
    }

    public void visitBody(int i, int j) {
        if (i < 0 || i >= map.length || j < 0 || j >= map[0].length) {
            return;
        }
        if (hadVisted[i][j]) {
            return;
        }
        if (map[i][j] == 0) {
            return;
        }
        hadVisted[i][j] = true;
        count++;
        visitBody(i + 1, j);
        visitBody(i - 1, j);
        visitBody(i, j + 1);
        visitBody(i, j - 1);
    }

    public static void main(String[] args) {
        System.out.print(new solution695().maxAreaOfIsland(
                new int[][] {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}}));
    }
}
