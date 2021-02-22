import java.util.*;

public class solution697 {
    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[2]++;
                map.get(nums[i])[1] = i;
            } else {
                map.put(nums[i], new int[] { i, i, 1 });
            }
        }
        int maxNum = 0, minLen = 0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] cur = entry.getValue();
            if (cur[2] > maxNum) {
                maxNum = cur[2];
                minLen = cur[1] - cur[0] + 1;
            } else if (cur[2] == maxNum && (cur[1] - cur[0] + 1 < minLen)) {
                minLen = cur[1] - cur[0] + 1;
            }
        }
        return minLen;
    }
}