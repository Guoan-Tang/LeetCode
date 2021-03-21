public class solution992 {
    public int subarraysWithKDistinct(int[] A, int K) {
        return core(A, K) - core(A, K - 1);
    }

    private int core(int[] nums, int k) {
        int[] freq = new int[nums.length + 1];
        int l = 0, r = 0, count = 0, res = 0;
        while (r < nums.length) {
            if (freq[nums[r]] == 0) {
                count++;
            }
            freq[nums[r++]]++;
            while (count > k) {
                freq[nums[l]]--;
                if (freq[nums[l++]] == 0) {
                    count--;
                }
            }
            res += (r - l);
        }
        return res;
    }
}