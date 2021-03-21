public class solution1319 {
    private int[] f;
    private int setCount;

    public int makeConnected(int n, int[][] connections) {
        int res = 0;
        f = new int[n];
        setCount = n;
        for (int i = 0; i < n; i++) {
            f[i] = i;
        }
        for (int[] edge : connections) {
            if (find(edge[0]) != find(edge[1])) {
                f[find(edge[0])] = f[find(edge[1])];
                setCount--;
            } else {
                res++;
            }
        }
        // 结果 = 集合数 - 1
        if (res >= (setCount - 1)) {
            return setCount - 1;
        }
        return -1;
    }

    private int find(int num) {
        if (f[num] != num) {
            f[num] = find(f[num]);
        }
        return f[num];
    }
}
