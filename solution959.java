public class solution959 {
    private int[] f;
    private int setCount;

    public int regionsBySlashes(String[] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        f = new int[n * n * 4];
        setCount = f.length;
        for (int i = 0; i < f.length; i++) {
            f[i] = i;
        }
        for (int i = 0; i < n; i++) {
            char[] row = grid[i].toCharArray();
            for (int j = 0; j < n; j++) {
                int startIndex = (n * i + j) * 4;
                char c = row[j];
                if (c == '/') {
                    union(startIndex, startIndex + 1);
                    union(startIndex + 2, startIndex + 3);
                } else if (c == '\\') {
                    union(startIndex, startIndex + 3);
                    union(startIndex + 1, startIndex + 2);
                } else {
                    union(startIndex, startIndex + 1);
                    union(startIndex, startIndex + 2);
                    union(startIndex, startIndex + 3);
                }
                if (j < n - 1) {
                    union(startIndex + 2, startIndex + 4);
                }
                if (i < n - 1) {
                    union(startIndex + 3, startIndex + 4 * n + 1);
                }   
            }
        }
        return setCount;
    }

    private int find(int num) {
        if (f[num] != num) {
            f[num] = find(f[num]);
        }
        return f[num];
    }

    private void union(int x, int y) {
        if (find(x) != find(y)) {
            setCount--;
            f[find(x)] = f[find(y)];
        }
    }
}