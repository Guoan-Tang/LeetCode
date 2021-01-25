package LeetCode;

public class solution33 {

    public int search(int[] nums, int target) {
        if (nums.length < 1) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                // left part
                if (nums[mid] > target) {
                    if (nums[0] <= target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    left = mid + 1;
                }
            } else {
                // right part
                if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    if (nums[0] > target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.print(new solution33().search(new int[]{4,5,6,7,0,1,2}, 0));
    }
}