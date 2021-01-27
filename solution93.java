

import java.util.LinkedList;
import java.util.List;

public class solution93 {
    List<String> res;
    char[] input;

    public List<String> restoreIpAddresses(String s) {
        input = s.toCharArray();
        res = new LinkedList<>();
        if (input.length > 12) {
            return res;
        }
        core(new StringBuilder(), 0, 1);

        return res;
    }

    public void core(StringBuilder curRes, int startIndex, int segCount) {
        if (startIndex > input.length) {
            return;
        }
        if (startIndex == input.length) {
            if (segCount == 5) {
                res.add(curRes.toString());
            }
            return;
        }
        if (input[startIndex] == '0') {
            StringBuilder temp = new StringBuilder(curRes);
            if (segCount != 1) {
                temp.append(".");
            }
            temp.append("0");
            core(temp, startIndex + 1, segCount + 1);
        } else {
            for (int i = startIndex; i < startIndex + 3; i++) {
                if (i < input.length) {
                    if (judge(startIndex, i)) {
                        // if current string is correct
                        StringBuilder temp = new StringBuilder(curRes);
                        if (segCount != 1) {
                            temp.append(".");
                        }
                        for (int j = startIndex; j <= i; j++) {
                            temp.append(input[j]);
                        }
                        core(temp, i + 1, segCount + 1);
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean judge(int left, int right) {
        // to judge if input string is suitable for ip address
        int temp = Integer.valueOf(new String(input, left, right + 1 - left));
        if (temp >= 1 && temp <= 255) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new solution93().restoreIpAddresses("0000"));
    }
}
