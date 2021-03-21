import java.util.*;

public class solutionJ59_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }
        int cur = 0;
        Deque<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        while (cur < nums.length) {
            if (cur - k >= 0 && nums[cur - k] == queue.peekFirst()) {
                queue.removeFirst();
            }
            while (!queue.isEmpty() && queue.peekLast() < nums[cur]) {
                queue.removeLast();
            }
            queue.addLast(nums[cur]);
            if (cur - k + 1 >= 0) {
                res[cur - k + 1] = queue.peekFirst();
            }
            cur++;
        }
        return res;
    }
}