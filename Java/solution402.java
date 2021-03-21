import java.util.*;

public class solution402 {
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() < 1) {
            return "0";
        }
        Deque<Character> stack = new LinkedList<>();
        char[] input = num.toCharArray();
        char preChar;
        stack.push(input[0]);
        int inputIndex = 1;
        while (k > 0 && inputIndex < input.length) {
            preChar = stack.peekLast();
            while (input[inputIndex] - preChar < 0 && k > 0) {
                stack.removeLast();
                k--;
                if (stack.isEmpty()) {
                    break;
                }
                preChar = stack.peekLast();
            }
            stack.addLast(input[inputIndex]);
            inputIndex++;
        }
        while (inputIndex < input.length) {
            stack.addLast(input[inputIndex++]);
        }
        while (k != 0) {
            stack.removeLast();
            k--;
        }
        if (stack.isEmpty()) {
            return "0";
        }
        preChar = stack.peekFirst();
        while (preChar == '0') {
            stack.removeFirst();
            if (stack.isEmpty()) {
                return "0";
            }
            preChar = stack.peekFirst();
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pollFirst());
        }
        return res.toString();
    }
}
