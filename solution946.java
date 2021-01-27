

import java.util.Stack;


public class solution946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> resStack = new Stack<Integer>();
        int left = 0, right = 0;
        while (right < popped.length) {
            if (!resStack.isEmpty()) {
                if (resStack.peek() == popped[right]) {
                    right++;
                    resStack.pop();
                } else {
                    if (left < pushed.length) {
                        resStack.push(pushed[left++]);
                    } else {
                        return false;
                    }
                }
            } else {
                if (left < pushed.length) {
                    resStack.push(pushed[left++]);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
