package LeetCode;

public class solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) {
            return "";
        }
        if (strs[0].length() < 1) {
            return "";
        }
        int res = 0;
        char temp = strs[0].charAt(0);
        while (true) {
            for (String s : strs) {
                if (res >= s.length()) {
                    return strs[0].substring(0, res);
                }
                if (temp != s.charAt(res)) {
                    return strs[0].substring(0, res);
                }
            }
            if (++res >= strs[0].length()) {
                return strs[0].substring(0, res);
            } else {
                temp = strs[0].charAt(res);
            }
        }
    }
}
