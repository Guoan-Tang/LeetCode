

public class solution977 {
    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        if ((A[0] <= 0 && A[A.length - 1] <= 0) || (A[0] >= 0 && A[A.length - 1] >= 0)) {
            if (A[A.length - 1] <= 0) {
                for (int i = 0; i < A.length; i++) {
                    res[i] = A[A.length - 1 - i] * A[A.length - 1 - i];
                }
            } else {
                for (int i = 0; i < A.length; i++) {
                    res[i] = A[i] * A[i];
                }
            }
        } else {
            int l = 0, r = A.length - 1, index = 0;
            while (l + 1 < A.length && A[l + 1] < 0) {
                l++;
            }
            while (r - 1 >= 0 && A[r - 1] > 0) {
                r--;
            }
            for (int i = l + 1; i < r; i++) {
                res[index++] = A[i] * A[i];
            }
            while (l >= 0 && r < A.length) {
                if (-A[l] > A[r]) {
                    res[index++] = A[r] * A[r];
                    r++;
                } else {
                    res[index++] = A[l] * A[l];
                    l--;
                }
            }
            while (l >= 0) {
                res[index++] = A[l] * A[l];
                l--;
            }
            while (r < A.length) {
                res[index++] = A[r] * A[r];
                r++;
            }
        }
        return res;
    }
}
