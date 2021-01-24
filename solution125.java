import java.util.*;

public class solution125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }
        LinkedList<Character> input = new LinkedList<>();
        char temp;
        for (int i = 0; i < s.length(); i++) {
            temp = s.charAt(i);
            if (temp >= 'a' && temp <= 'z') {
                temp = (char)(temp - 32);
                input.add(temp);
            } else if ((temp >= '0' && temp <= '9') || (temp >= 'A' && temp <= 'Z')) {
                input.add(temp);
            }
        }
        char[] sc = new char[input.size()];
        for (int i = 0; i < input.size(); i++) {
            sc[i] = input.get(i);
        }
        if (sc.length > 0) {
            for (int i = 0; i <= sc.length / 2; i++) {
                if (sc[i] != sc[sc.length - 1 - i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
