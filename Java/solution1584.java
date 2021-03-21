import java.util.*;

public class solution1584 {
    private int[] f;

    public int minCostConnectPoints(int[][] points) {
        f = new int[points.length];
        for (int i = 0; i < f.length; i++) {
            f[i] = i;
        }
        ArrayList<EDGE> edges = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                edges.add(
                        new EDGE(Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]), i, j));
            }
        }
        Collections.sort(edges, (a, b) -> a.len - b.len);
        int res = 0;
        for (EDGE edge : edges) {
            if (find(edge.x) != find(edge.y)) {
                res += edge.len;
                union(edge.x, edge.y);
            }
        }
        return res;
    }

    private int find(int num) {
        if (f[num] != num) {
            f[num] = find(f[num]);
        }
        return f[num];
    }

    private void union(int num0, int num1) {
        f[find(num0)] = find(num1);
    }

    class EDGE {
        int len, x, y;

        public EDGE(int len, int x, int y) {
            this.len = len;
            this.x = x;
            this.y = y;
        }
    }
}
