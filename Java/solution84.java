import java.util.Stack;

public class solution84 {
    public int largestRectangleArea(int[] heights) {
        int[] nh = new int[heights.length + 2];
        nh[0] = 0;
        nh[nh.length - 1] = 0;
        for (int i = 0; i < heights.length; i++) {
            nh[i + 1] = heights[i];
        }
        heights = nh;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int temp, res = 0;
        for (int i = 1; i < heights.length; i++) {
            while (heights[stack.peek()] > heights[i]) {
                temp = heights[stack.pop()];
                temp *= (i - stack.peek() - 1);
                if (temp > res) {
                    res = temp;
                }
            }
            stack.push(i);
        }
        return res;
    }
}
