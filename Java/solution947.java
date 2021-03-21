import java.util.*;

public class solution947 {
    private HashMap<Integer, Integer> map;
    private int res;

    public int removeStones(int[][] stones) {
        if (stones == null) {
            return 0;
        }
        // 找出连通分量的的数量
        map = new HashMap<>();
        res = 0;
        for (int[] stone : stones) {
            union(stone[0] + 10001, stone[1]);
        }
        return stones.length - res;
    }

    private int find(int num) {
        if (!map.containsKey(num)) {
            res++;
            map.put(num, num);
        } else if (map.get(num) != num) {
            map.put(num, find(map.get(num)));
        }
        return map.get(num);
    }

    private void union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX != rootY) {
            map.put(rootX,rootY);
            res--;
        }
    }
}