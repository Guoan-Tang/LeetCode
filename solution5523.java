package LeetCode;

public class solution5523 {
    public int minOperations(String[] logs) {
        int res = 0;
        for (String s : logs) {
            if (s.charAt(0) == '.') {
                if (s.charAt(1) == '.') {
                    if (res != 0) {
                        res--;
                    }
                }
            } else {
                res++;
            }
        }
        return res;
    }
}
