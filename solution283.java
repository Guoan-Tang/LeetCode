public class solution283 {
    public void moveZeroes(int[] nums) {
        int insertIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (insertIndex != i) {
                    nums[insertIndex] = nums[i];
                }
                insertIndex++;
            }
        }
        for (int i = insertIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}