public class solution684 {
    private int[] father;

    public int[] findRedundantConnection(int[][] edges) {
        father = new int[edges.length + 1];
        for (int i = 1; i < edges.length; i++) {
            father[i] = i;
        }
        for (int i = 0; i <= edges.length - 1; i++) {
            int[] edge = edges[i];
            if (find(edge[0]) != find(edge[1])) {
                union(edge[0], edge[1]);
            } else {
                return edge;
            }
        }
        return new int[0];
    }

    private void union(int a, int b) {
        father[find(a)] = father[find(b)];
    }

    private int find(int a) {
        if (father[a] == a) {
            return a;
        }
        father[a] = find(father[a]);
        return father[a];
    }
}