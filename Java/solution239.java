import java.util.*;

public class solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Queue<int[]> pq = new PriorityQueue<>((int[] a, int[] b)-> {return a[0] == b[0] ? b[1] - a[1] : b[0] - a[0];});
        int i = 0, resIndex = 0;
        for (; i < k; i++) {
            pq.offer(new int[]{nums[i],i});
        }
        res[resIndex++] = pq.peek()[0];
        while (i < nums.length) {
            pq.offer(new int[]{nums[i],i});
            while (pq.peek()[1] <= (i - k)) {
                pq.poll();
            }
            res[resIndex++] = pq.poll()[0];
            i++;
        }
        return res;
    }
}
