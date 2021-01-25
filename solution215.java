package LeetCode;

public class solution215 {
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        // k--;
        // for (int i = 1; i < nums.length; i++) {
        // if (nums[i] != nums[i - 1]) {
        // k--;
        // }
        // if (k == 0) {
        // return nums[i];
        // }
        // }
        return nums[k - 1];
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = partition(nums, left, right);
            quickSort(nums, left, mid - 1);
            quickSort(nums, mid + 1, right);
        }
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left], pivotPos = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > pivot) {
                pivotPos++;
                if (i != pivotPos) {
                    int temp = nums[i];
                    nums[i] = nums[pivotPos];
                    nums[pivotPos] = temp;
                }
            }
        }
        int temp = nums[left];
        nums[left] = nums[pivotPos];
        nums[pivotPos] = temp;
        return pivotPos;
    }

    public static void main(String[] args) {
        System.out
                .print(new solution215().findKthLargest(new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
