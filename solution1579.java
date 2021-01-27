public class solution1579 {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        if (n < 1 || edges == null || edges.length < 1) {
            return 0;
        }
        int res = 0;
        unionFind u0 = new unionFind(n);
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (!u0.union(edge[1], edge[2])) {
                    res++;
                }
            }
        }
        unionFind u1 = new unionFind(u0);
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (!u0.union(edge[1], edge[2])) {
                    res++;
                }
            } else if (edge[0] == 2) {
                if (!u1.union(edge[1], edge[2])) {
                    res++;
                }
            }
        }
        if (u0.setNum() != 1 || u1.setNum() != 1) {
            return -1;
        }
        return res;
    }

    class unionFind {
        private int[] f;
        private int setNum;
        
        public unionFind(unionFind u0) {
            f = new int[u0.f.length];
            for (int i = 0; i < u0.f.length; i++) {
                f[i] = u0.f[i];
            }
            setNum = u0.setNum;
        }

        public unionFind(int size) {
            f = new int[size + 1];
            for (int i = 0; i < size; i++) {
                f[i] = i;
            }
            setNum = size;
        }

        public int setNum() {
            return setNum;
        }

        public int find(int num) {
            if (f[num] != num) {
                f[num] = find(f[num]);
            }
            return f[num];
        }

        public boolean union(int x, int y) {
            if (find(x) != find(y)) {
                f[find(x)] = find(y);
                setNum--;
                return true;
            } else {
                return false;
            }
        }
    }
}
