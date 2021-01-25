package LeetCode;

public class solution925 {
    public boolean isLongPressedName(String name, String typed) {
        // char[] a = name.toCharArray(), b = typed.toCharArray();
        int i = 0, j = 0;
        while (i != name.length() && j != typed.length()) {
            if (name.charAt(i) != typed.charAt(j)) {
                if (i > 0 && name.charAt(i - 1) == typed.charAt(j)) {
                    j++;
                } else {
                    return false;
                }
            } else {
                i++;
                j++;
            }
        }
        while (j != typed.length()) {
            if (name.charAt(i - 1) != typed.charAt(j)) {
                return false;
            }
            j++;
        }
        if (i != name.length()) {
            return false;
        }
        return true;
    }
}
