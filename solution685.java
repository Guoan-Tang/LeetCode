

public class solution685 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        // the number of nodes equal the number of edges cause there is an extra edge
        int nodesNum = edges.length;
        // there are no node that can be represented as 0
        UnionFind uf = new UnionFind(nodesNum + 1);
        int[] parent = new int[nodesNum + 1];
        // initialize parent array
        for (int i = 1; i <= nodesNum; i++) {
            parent[i] = i;
        }
        int conflict = -1, cycle = -1, node1, node2;
        int[] edge;
        for (int i = 0; i < nodesNum; i++) {
            // go through every edge
            edge = edges[i];
            node1 = edge[0];
            node2 = edge[1];
            if (parent[node2] != node2) {
                // the parent of current node isn't itself
                conflict = i;
            } else {
                parent[node2] = node1;
                if (uf.find(node1) == uf.find(node2)) {
                    cycle = i;
                } else {
                    uf.union(node1, node2);
                }
            }
        }
        if (conflict < 0) {
            // if no conflict the redundant edge is the edge that cause cycle
            int[] redundant = { edges[cycle][0], edges[cycle][1] };
            return redundant;
        } else {
            int[] conflictEdge = edges[conflict];
            if (cycle >= 0) {
                // there is a edge that cause cycle
                int[] redundant = { parent[conflictEdge[1]], conflictEdge[1] };
                return redundant;
            } else {
                int[] redundant = {conflictEdge[0], conflictEdge[1]};
                return redundant;
            }
        }
    }

}

class UnionFind {
    private int[] father;

    UnionFind(int size) {
        // initialize union find
        father = new int[size];
        for (int i = 0; i < size; i++) {
            father[i] = i;
        }
    }

    public int find(int i) {
        // find the represent element of i
        if (father[i] != i) {
            father[i] = find(father[i]);
        }
        return father[i];
    }

    public void union(int x, int y) {
        father[find(y)] = find(x);
    }
}