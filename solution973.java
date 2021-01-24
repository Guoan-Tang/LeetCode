import java.util.*;

public class solution973 {
    public int[][] kClosest(int[][] points, int K) {
        List<item> list = new ArrayList<>();
        for (int[] cur : points) {
            list.add(new item(cur[0], cur[1]));
        }
        Collections.sort(list);
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            item cur = list.get(i);
            res[i][0] = cur.x;
            res[i][1] = cur.y;
        }
        return res;
    }

    class item implements Comparable<item> {
        int x;
        int y;
        double sqrt;

        public item(int x1, int x2) {
            this.x = x1;
            this.y = x2;
            this.sqrt = Math.sqrt(x * x + y * y);
        }

        @Override
        public int compareTo(item target) {
            if (sqrt > target.sqrt) {
                return -1;
            } else if (sqrt == target.sqrt) {
                return 0;
            } else {
                return 1;
            }
        }
    }
}