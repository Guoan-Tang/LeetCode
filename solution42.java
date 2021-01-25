package LeetCode;

public class solution42 {
    public int trap(int[] height) {
        if (height.length < 1) {
            return 0;
        }
        int[] leftMaxHeight = new int[height.length];
        int[] rightMaxHeight = new int[height.length];
        int res = 0;
        leftMaxHeight[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMaxHeight[i] = Math.max(leftMaxHeight[i - 1], height[i]);
        }
        rightMaxHeight[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMaxHeight[i] = Math.max(rightMaxHeight[i + 1], height[i]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            if (height[i] < leftMaxHeight[i] && height[i] < rightMaxHeight[i]) {
                int limitHeight = Math.min(leftMaxHeight[i], rightMaxHeight[i]);
                res += (limitHeight - height[i]);
            }
        }
        return res;
    }
}
