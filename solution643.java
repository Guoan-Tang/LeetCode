public class solution643 {
    public double findMaxAverage(int[] nums, int k) {
        if (k < 1 || nums == null || nums.length < k) {
            return 0;
        }
        double res = 0, sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        res = sum;
        for (int i = 0; i < nums.length - k; i++) {
            sum += nums[k + i];
            sum -= nums[i];
            res = Math.max(res, sum);
        }
        return res / k;
    }
}
