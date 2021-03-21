public class solutionJ53_1 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        // find right index of target range first
        int l = 0, r = nums.length - 1, mid = (l + r) / 2;
        while (l <= r) {
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
            mid = (l + r) / 2;
        }
        if (r >= 0 && nums[r] != target) {
            return 0;
        }
        // then find left index of target range
        int right = r;
        l = 0;
        r = nums.length - 1;
        mid = (l + r) / 2;
        while (l <= r) {
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
            mid = (l + r) / 2;
        }
        return right - l + 1;
    }

    // another solution

    // public int search(int[] nums, int target) {
    //     if (nums == null || nums.length < 1) {
    //         return 0;
    //     }
    //     int l = 0, r = nums.length - 1, mid = (l + r) / 2;
    //     while (nums[mid] != target && l < r) {
    //         if (nums[mid] > target) {
    //             r = mid - 1;
    //         } else {
    //             l = mid + 1;
    //         }
    //         mid = (l + r) / 2;
    //     }
    //     if (nums[mid] != target) {
    //         return 0;
    //     } else {
    //         int res = 1;
    //         l = mid - 1;
    //         r = mid + 1;
    //         while (l >= 0 && nums[l] == target) {
    //             res++;
    //             l--;
    //         }
    //         while (r < nums.length && nums[r] == target) {
    //             res++;
    //             r++;
    //         }
    //         return res;
    //     }
    // }
}