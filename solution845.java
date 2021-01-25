package LeetCode;

public class solution845 {
    public int longestMountain(int[] A) {
        int res = 0;
        if (A == null || A.length < 1) {
            return res;
        }
        int[] increase = new int[A.length];
        int[] decrease = new int[A.length];
        increase[0] = 0;
        decrease[decrease.length - 1] = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                increase[i] = increase[i - 1] + 1;
            } else {
                increase[i] = 0;
            }
        }
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                decrease[i] = decrease[i + 1] + 1;
            } else {
                decrease[i] = 0;
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (increase[i] > 0 && decrease[i] > 0) {
                res = Math.max(increase[i] + decrease[i] + 1, res);
            }
        }
        return res;
    }
}
