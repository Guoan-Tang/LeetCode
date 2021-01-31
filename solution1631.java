import java.util.*;

public class solution1631 {
    private int f[];

    public int minimumEffortPath(int[][] heights) {
        if (heights == null || (heights.length == 1 && heights[0].length == 1) || heights.length == 0) {
            return 0;
        }
        f = new int[heights.length * heights[0].length];
        for (int i = 0; i < f.length; i++) {
            f[i] = i;
        }
        ArrayList<edge> edges = new ArrayList<edge>((heights.length - 1) * heights[0].length + (heights[0].length - 1) * heights.length);
        for (int i = 0; i < heights.length - 1; i++) {
            for (int j = 0; j < heights[i].length - 1; j++) {
                edges.add(new edge(i * heights[0].length + j, i * heights[0].length + j + 1, Math.abs(heights[i][j] - heights[i][j + 1])));
                edges.add(new edge(i * heights[0].length + j, (i + 1) * heights[0].length + j, Math.abs(heights[i][j] - heights[i + 1][j])));
            }
        }
        for (int i = 0; i < heights.length - 1; i++) {
            edges.add(new edge(i * heights[0].length + heights[0].length - 1, (i + 1) * heights[0].length + heights[0].length - 1, Math.abs(heights[i][heights[0].length - 1] - heights[i + 1][heights[0].length - 1])));
        }
        for (int i = 0; i < heights[0].length - 1; i++) {
            edges.add(new edge((heights.length - 1) * heights[0].length + i, (heights.length - 1) * heights[0].length + i + 1, Math.abs(heights[heights.length - 1][i] - heights[heights.length - 1][i + 1])));
        }
        Collections.sort(edges, new Comparator<edge>(){
            public int compare(edge x, edge y) {
                return x.val - y.val;
            }
        });
        for (edge e : edges) {
            union(e.x, e.y);
            if (find(0) == find(heights.length * heights[0].length - 1)) {
                return e.val;
            }
        }
        return -1;
    }

    private int find(int num) {
        if (f[num] != num) {
            f[num] = find(f[num]);
        }
        return f[num];
    }

    private void union(int x, int y) {
        f[find(x)] = f[find(y)];
    }

    private class edge {
        public int x, y, val;
        public edge(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}