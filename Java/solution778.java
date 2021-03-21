import java.util.*;

public class solution778 {
    private int[] f;

    public int swimInWater(int[][] grid) {
        f = new int[grid.length * grid.length];
        for (int i = 0; i < f.length; i++) {
            f[i] = i;
        }
        List<NODE> nodes = new ArrayList<>(f.length);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                nodes.add(new NODE(i, j, grid[i][j]));
            }
        }
        Collections.sort(nodes, new Comparator<NODE>(){
            @Override
            public int compare(NODE x, NODE y) {
                return x.val - y.val;
            }
        });
        for (NODE node : nodes) {
            if (node.x > 0 && grid[node.x - 1][node.y] <= node.val) {
                union((node.x - 1) * grid.length + node.y, node.x * grid.length + node.y);
            }
            if (node.x < grid.length - 1 && grid[node.x + 1][node.y] <= node.val) {
                union((node.x + 1) * grid.length + node.y, node.x * grid.length + node.y);
            }
            if (node.y > 0 && grid[node.x][node.y - 1] <= node.val) {
                union(node.x * grid.length + node.y - 1, node.x * grid.length + node.y);
            }
            if (node.y < grid.length - 1 && grid[node.x][node.y + 1] <= node.val) {
                union(node.x * grid.length + node.y + 1, node.x * grid.length + node.y);
            }
            if (find(0) == find(grid.length * grid.length - 1)) {
                return node.val;
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

    public void union(int x, int y) {
        f[find(x)] = f[find(y)];
    }

    class NODE {
        int x,y,val;

        public NODE(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}