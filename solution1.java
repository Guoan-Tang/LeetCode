import java.util.*;

public class solution1 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length < 2) {
            return res;
        }
        HashMap<Integer, Integer> myMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (myMap.containsKey(nums[i])) {
                res[0] = myMap.get(nums[i]);
                res[1] = i;
                return res;
            }
            myMap.put(target - nums[i], i);
        }
        return res;
    }
}
