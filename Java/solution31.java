public class solution31 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }
        int i = nums.length - 1;
        while (i > 0) {
            if (nums[i - 1] < nums[i]) {
                break;
            }
            i--;
        }
        if (i == 0) {
            quickSort(nums, 0, nums.length - 1);
            return;
        }
        quickSort(nums, i, nums.length - 1);
        for (int j = i; j < nums.length; j++) {
            if (nums[j] > nums[i - 1]) {
                swap(nums, j, i - 1);
                break;
            }
        }
    }

    public void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int mid = partition(nums, l, r);
            quickSort(nums, l, mid - 1);
            quickSort(nums, mid + 1, r);
        }
    }

    public int partition(int[] nums, int l, int r) {
        int pivot = nums[l], pivotPos = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] < pivot) {
                pivotPos++;
                if (i != pivotPos) {
                    swap(nums, pivotPos, i);
                }
            }
        }
        swap(nums, l, pivotPos);
        return pivotPos;
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
