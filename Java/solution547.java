import java.util.*;

public class solution547 {
    public int findCircleNum(int[][] isConnected) {
        int res = 0;
        if (isConnected == null || isConnected.length < 1) {
            return res;
        }

        boolean[] hadConnected = new boolean[isConnected.length];
        Arrays.fill(hadConnected, false);
        for (int i = 0; i < hadConnected.length; i++) {
            if (!hadConnected[i]) {
                hadConnected[i] = true;
                res++;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int curCity = queue.poll();
                    for (int j = 0; j < isConnected.length; j++) {
                        if (isConnected[curCity][j] != 0 && !hadConnected[j]) {
                            hadConnected[j] = true;
                            queue.offer(j);
                        }
                    }
                }
            }
        }
        return res;
    }
}
