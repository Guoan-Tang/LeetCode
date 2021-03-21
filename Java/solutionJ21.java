

public class solutionJ21 {
    public int[] exchange(int[] nums) {
        int left = 0, right = 0, temp;
        while (right < nums.length) {
            if (nums[right] % 2 == 1) {
                if (left != right) {
                    temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                }
                left++;
                right++;
            } else {
                right++;
            }
        }
        return nums;
    }
}
