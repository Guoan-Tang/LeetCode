public class solutionJ51 {
    private int mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return 0;
        }
        int[] tempArr = new int[r - l + 1];
        int mid = (l + r) / 2, index0 = mid + 1, index1 = 0, startIndex = l;
        int res = mergeSort(nums, l, mid) + mergeSort(nums, mid + 1, r);
        while (l <= mid && index0 <= r) {
            if (nums[l] <= nums[index0]) {
                tempArr[index1] = nums[l];
                res += (index0 - mid - 1);
                l++;
            } else if (nums[l] > nums[index0]) {
                tempArr[index1] = nums[index0];
                index0++;
            }
            index1++;
        }
        for (int i = l; i <= mid; i++) {
            tempArr[index1++] = nums[i];
            res += (index0 - mid - 1);
        }
        for (int i = index0; i <= r; i++) {
            tempArr[index1++] = nums[i];
        }
        for (int i = 0; i < tempArr.length; i++) {
            nums[startIndex + i] = tempArr[i];
        }
        return res;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}
