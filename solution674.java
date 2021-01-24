public class solution674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int pre = 1, res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                pre++;
            } else {
                res = res > pre ? res : pre;
                pre = 1;
            }
        }
        return res > pre ? res : pre;
    }
}
