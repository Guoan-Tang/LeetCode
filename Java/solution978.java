public class solution978 {
    public int maxTurbulenceSize(int[] arr) {
        if (arr == null) {
            return 0;
        }
        int l = 0, r = 0, res = 1;
        while (r < arr.length - 1) {
            if (l == r) {
                if (arr[l] == arr[l + 1]) {
                    l++;
                }
                r++;
            } else {
                if (arr[r - 1] < arr[r] && arr[r] > arr[r + 1]) {
                    r++;
                } else if (arr[r - 1] > arr[r] && arr[r] < arr[r + 1]) {
                    r++;
                } else {
                    l = r;
                }
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}