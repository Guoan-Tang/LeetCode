import java.util.*;

public class solution1483 {

    class TreeAncestor {
        List<List<Integer>> dp;

        public TreeAncestor(int n, int[] parent) {
            dp = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                LinkedList<Integer> temp = new LinkedList<>();
                temp.add(parent[i]);
                dp.add(temp);
            }
            for (int j = 1;; j++) {
                boolean flag = true;
                for (int i = 0; i < n; i++) {
                    int t = dp.get(i).get(j - 1) == -1 ? dp.get(dp.get(i).get(j - 1)).get(j - 1) : -1;
                    dp.get(i).add(t);
                    if (t != -1) {
                        flag = false;
                    }
                }
                if (flag) {
                    break;
                }
            }
        }

        public int getKthAncestor(int node, int k) {
            int res = node, pos = 0;
            while (k != 0 && res != -1) {
                if (pos >= dp.get(res).size()) {
                    return -1;
                }
                if ((k & 1) != 0) {
                    res = dp.get(res).get(pos);
                }
                k >>= 1;
                pos++;
            }
            return res;
        }
    }

}
