

import java.util.*;

class Solution {
    private int[] dp;
    private int[] sz;
    private int[] res;
    private ArrayList<LinkedList<Integer>> graph;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        res = new int[N];
        if (N < 1 || edges == null) {
            return res;
        }
        sz = new int[N];
        dp = new int[N];
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new LinkedList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        dfs(0, -1);
        dfs2(0, -1);
        return res;
    }

    public void dfs(int u, int p) {
        sz[u] = 1;
        dp[u] = 0;
        LinkedList<Integer> temp = graph.get(u);
        for (int v : temp) {
            if (v == p) {
                continue;
            }
            dfs(v, u);
            sz[u] += sz[v];
            dp[u] += dp[v] + sz[v];
        }
    }

    public void dfs2(int u, int p) {
        res[u] = dp[u];
        LinkedList<Integer> temp = graph.get(u);
        for (int v : temp) {
            if (v == p) {
                continue;
            }
            int a = dp[u], b = sz[u], c = dp[v], d = sz[v];
            dp[u] -= dp[v] + sz[v];
            sz[u] -= sz[v];
            dp[v] += dp[u] + sz[u];
            sz[v] += sz[u];
            dfs2(v, u);
            dp[u] = a;
            sz[u] = b;
            dp[v] = c;
            sz[v] = d;
        }
    }
}