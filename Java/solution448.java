import java.util.*;

public class solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new LinkedList<>();
        if (nums == null) {
            return res;
        }
        int n = nums.length;
        for (int i : nums) {
            if (i > n) {
                i %= (n + 1);
            }
            nums[i - 1] += (n + 1);
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
