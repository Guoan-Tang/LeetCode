public class solution485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, index = 0;
        if (nums == null) {
            return res;
        }
        while (index < nums.length) {
            if (nums[index] == 1) {
                int start = index;
                while (index < nums.length && nums[index] == 1) {
                    index++;
                }
                res = Math.max(index - start, res);
            }
            index++;
        }
        return res;
    }
}