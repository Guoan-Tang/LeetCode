import java.util.*;

public class solution224 {
    public int calculate(String s) {
        Stack<Integer> ops = new Stack<Integer>();
        ops.push(1);
        int sign = 1, res = 0, n = s.length(), i = 0;
        char[] charArr = s.toCharArray();
        while (i < n) {
            if (charArr[i] == ' ') {
                i++;
            } else if (charArr[i] == '+') {
                sign = ops.peek();
                i++;
            } else if (charArr[i] == '-') {
                sign = -ops.peek();
                i++;
            } else if (charArr[i] == '(') {
                ops.push(sign);
                i++;
            } else if (charArr[i] == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && charArr[i] >= '0' && charArr[i] <= '9') {
                    num = num * 10 + charArr[i] - '0';
                    i++;
                }
                res += sign * num;
            }
        }
        return res;
    }
}
