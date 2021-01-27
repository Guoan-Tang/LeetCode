

public class solution75 {
    public void sortColors(int[] nums) {
        int l = -1, r = nums.length;
        for (int i = 0; i < r; i++) {
            if (nums[i] == 0) {
                l++;
                if (l != i) {
                    swap(nums, l, i);
                    i--;
                }
            } else if (nums[i] == 2) {
                r--;
                swap(nums, r, i);
                i--;
            }
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
