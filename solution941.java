public class solution941 {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        if (A[1] <= A[0]) {
            return false;
        }
        boolean up = true;
        for (int i = 0; i < A.length - 1; i++) {
            if (up) {
                if (A[i] > A[i + 1]) {
                    up = false;
                }
                if (A[i] == A[i + 1]) {
                    return false;
                }
            } else {
                if (A[i] < A[i + 1]) {
                    return false;
                }
                if (A[i] == A[i + 1]) {
                    return false;
                }
            }
        }
        if (up) {
            return false;
        }
        return true;
    }
}