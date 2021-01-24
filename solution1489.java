import java.util.*;

public class solution1489 {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<List<Integer>> res = new ArrayList<>(2);
        res.add(new LinkedList<>());
        res.add(new LinkedList<>());
        if (edges.length < 1) {
            return res;
        }
        int m = edges.length;
        int[][] newEdges = new int[m][4];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                newEdges[i][j] = edges[i][j];
            }
            newEdges[i][3] = i;
        }
        Arrays.sort(newEdges, new Comparator<int[]>() {
            @Override
            public int compare(int[] x, int[] y) {
                return x[2] - y[2];
            }
        });
        UnionFind uf = new UnionFind(n);
        int value = 0;
        for (int[] edge : newEdges) {
            if (!uf.union(edge[0], edge[1])) {
                value += edge[2];
            }
        }
        for (int i = 0; i < m; i++) {
            // iterate through each edge
            
            uf = new UnionFind(n);
            int v = 0;
            for (int j = 0; j < m; j++) {
                if (i != j && !uf.union(newEdges[j][0], newEdges[j][1])) {
                    v += newEdges[j][2];
                }
            }
            if (uf.getSetCount() != 1) {
                res.get(0).add(newEdges[i][3]);
            } else if (v > value) {
                res.get(0).add(newEdges[i][3]);
            } else {
                uf = new UnionFind(n);
                v = newEdges[i][2];
                uf.union(newEdges[i][0], newEdges[i][1]);
                for (int j = 0; j < m; j++) {
                    if (i != j && !uf.union(newEdges[j][0], newEdges[j][1])) {
                        v += newEdges[j][2];;
                    }
                }
                if (v == value) {
                    res.get(1).add(newEdges[i][3]);
                }
            }
        }
        return res;
    }

    class UnionFind {
        private int[] f;
        private int setCount;

        public UnionFind(int size) {
            setCount = size;
            f = new int[size];
            for (int i = 0; i < size; i++) {
                f[i] = i;
            }
        }

        public boolean union(int x, int y) {
            if (find(x) == find(y)) {
                return true;
            } else {
                f[find(x)] = f[find(y)];
                setCount--;
                return false;
            }
        }

        public int getSetCount() {
            return setCount;
        }

        private int find(int num) {
            if (f[num] != num) {
                f[num] = find(f[num]);
            }
            return f[num];
        }
    }
}