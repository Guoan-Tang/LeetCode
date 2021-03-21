import java.util.*;

public class solution1438 {
    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return y - x;
            }
        }), minQueue = new PriorityQueue<>();
        // 通过两个单调队列来维护当前窗口中的最大值和最小值
        int l = 0, r = 0;
        while (r < nums.length) {
            maxQueue.offer(nums[r]);
            minQueue.offer(nums[r]);
            if (maxQueue.peek() - minQueue.peek() > limit) {
                maxQueue.remove(nums[l]);
                minQueue.remove(nums[l]);
                l++;
            }
            r++;
        }
        return r - l;
    }
}
