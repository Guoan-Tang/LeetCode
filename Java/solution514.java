import java.util.*;

public class solution514 {
    public int findRotateSteps(String ring, String key) {
        if ((ring == null || ring.length() < 1) || (key == null || key.length() < 1)) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        char[] r = ring.toCharArray(), k = key.toCharArray();
        int[][] dp = new int[k.length][r.length];
        Map<Character, List<Integer>> map = new HashMap<>();
        LinkedList<Integer> find = new LinkedList<>();
        for (char c : k) {
            if (!map.containsKey(c)) {
                find.clear();
                for (int i = 0; i < r.length; i++) {
                    if (r[i] == c) {
                        find.add(i);
                    }
                }
                map.put(c, new ArrayList<>(find));
            }
        }

        // initialize dp array first row
        List<Integer> tmp = map.get(k[0]), preTmp = tmp;
        for (int i : tmp) {
            dp[0][i] = Math.min(i, r.length - i);
        }

        // start dp
        int minCount;
        for (int i = 1; i < k.length; i++) {
            tmp = map.get(k[i]);
            for (int j : tmp) {
                // each j in ring where ring[j]==key[i]
                minCount = Integer.MAX_VALUE;
                for (int m : preTmp) {
                    // each m in ring where ring[m]==key[i-1]
                    minCount = Math.min(Math.min(Math.abs(m - j), r.length - Math.abs(m - j)) + dp[i - 1][m], minCount);
                }
                dp[i][j] = minCount;
            }
            preTmp = tmp;
        }

        for (int i : preTmp) {
            res = Math.min(dp[k.length - 1][i], res);
        }
        return res + k.length;
    }
}
