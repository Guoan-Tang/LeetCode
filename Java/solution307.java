public class solution307 {
    class NumArray {
        private int[] tree;
        private int len;

        public NumArray(int[] nums) {
            if (nums.length > 0) {
                len = nums.length;
                tree = new int[len * 2];
                buildTree(nums);
            }
        }

        private void buildTree(int[] nums) {
            for (int i = len, j = 0; i < 2 * len; i++, j++) {
                tree[i] = nums[j];
            }
            for (int i = len - 1; i >= 0; i--) {
                tree[i] = tree[i * 2] + tree[i * 2 + 1];
            }
        }

        public void update(int index, int val) {
            index += len;
            int change = val - tree[index];
            tree[index] += change;
            while (index > 0) {
                index /= 2;
                tree[index] += change;
            }
        }

        public int sumRange(int left, int right) {
            int l = left + len, r = right + len, res = 0;
            while (l <= r) {
                if (l % 2 == 1) {
                    res += tree[l];
                    l++;
                }
                if (r % 2 == 0) {
                    res += tree[r];
                    r--;
                }
                l /= 2;
                r /= 2;
            }
            return res;
        }
    }
}
