public class solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[nums1.length];
        int a = 0, b = 0, c = 0;
        while (a < m && b < n) {
            if (nums1[a] < nums2[b]) {
                res[c++] = nums1[a++];
            } else {
                res[c++] = nums2[b++];
            }
        }
        while (a < m) {
            res[c++] = nums1[a++];
        }
        while (b < n) {
            res[c++] = nums2[b++];
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = res[i];
        }
    }
}