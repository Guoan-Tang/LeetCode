public class solution628 {
    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int max0 = Integer.MIN_VALUE, max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, min0 = Integer.MAX_VALUE, min1 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > max0) {
                max2 = max1;
                max1 = max0;
                max0 = num;
            } else if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
            if (num < min0) {
                min1 = min0;
                min0 = num;
            } else if (num < min1) {
                min1 = num;
            }
        }
        return Math.max(max0 * max1 * max2, max0 * min0 * min1);
    }
}
