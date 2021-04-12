
public class solution215 {
    public int findKthLargest(int[] nums, int k) {
        int temp;
        for (int i = nums.length / 2; i >= 0; i--) {
            heapify(nums, i, nums.length);
        }
        for (int i = 0; i < k; i++) {
            temp = nums[0];
            nums[0] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
            heapify(nums, 0, nums.length - i - 1);
        }
        return nums[0];
    }

    // ++++++++++++++++++++++++ heap sort ++++++++++++++++++++++++
    private void heapify(int[] nums, int startIndex, int length) {
        int leftIndex = 2 * startIndex + 1, rightIndex = 2 * startIndex + 2, targetIndex = startIndex;
        if (leftIndex < length && nums[leftIndex] > nums[targetIndex]) {
            targetIndex = leftIndex;
        }
        if (rightIndex < length && nums[rightIndex] > nums[targetIndex]) {
            targetIndex = rightIndex;
        }
        if (targetIndex != startIndex) {
            leftIndex = nums[startIndex];
            nums[startIndex] = nums[targetIndex];
            nums[targetIndex] = leftIndex;
            heapify(nums, targetIndex, length);
        }
    }

    // ++++++++++++++++++++++++ select the kth latge item after quick sort
    // ++++++++++++++++++++++++
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
}
