public class solution1004 {
    public int longestOnes(int[] A, int K) {
        int l = 0, r = 0, count = 0;
        while (r < A.length) {
            if (A[r++] == 0) {
                count++;
            }
            if (count > K) {
                if (A[l++] == 0) {
                    count--;
                }
            }
        }
        return r - l;
    }
}
