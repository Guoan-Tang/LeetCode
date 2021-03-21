public class solution34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length < 1) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        int curIndex = nums.length >> 1, l = 0, r = nums.length - 1;
        while (nums[curIndex] != target && l < r) {
            if (nums[curIndex] > target) {
                r = curIndex - 1;
                curIndex = (l + r) / 2;
            } else {
                l = curIndex + 1;
                curIndex = (l + r) / 2;
            }
        }
        if (nums[curIndex] != target) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        l = curIndex;
        r = curIndex;
        while (l > 0 && nums[l - 1] == target) {
            l--;
        }
        res[0] = l;
        while (r < nums.length - 1 && nums[r + 1] == target) {
            r++;
        }
        res[1] = r;
        return res;
    }

    public static void main(String[] args) {
        solution34 s = new solution34();
        int[] nums = {5,7,7,8,8,10};
        s.searchRange(nums, 6);
    }
}