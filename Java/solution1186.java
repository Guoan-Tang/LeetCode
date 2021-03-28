public class solution1186 {
    public int maximumSum(int[] arr) {
        if (arr.length < 1) {
            return 0;
        }
        int res = arr[0];
        int[] dpUnskip = new int[arr.length], dpSkip = new int[arr.length];
        dpUnskip[0] = arr[0];
        dpSkip[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            dpUnskip[i] = arr[i];
            if (dpUnskip[i - 1] > 0) {
                dpUnskip[i] += dpUnskip[i - 1];
            }
            dpSkip[i] = Math.max(dpUnskip[i - 1], dpSkip[i - 1] + arr[i]);
            if (dpUnskip[i] > res) {
                res = dpUnskip[i];
            }
            if (dpSkip[i] > res) {
                res = dpSkip[i];
            }
        }
        return res;
    }
}
