public class solution189 {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k == 0) {
            return;
        }

        k %= nums.length;
        int count = gcd(nums.length, k);
        for (int i = 0; i < count; i++) {
            int startNum = i, curNum = (i + k) % nums.length, temp0, temp1 = nums[curNum];
            nums[curNum] = nums[startNum];
            while (curNum != startNum) {
                curNum = (curNum + k) % nums.length;
                temp0 = nums[curNum];
                nums[curNum] = temp1;
                temp1 = temp0;
            }
        }
    }

    private int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }
}