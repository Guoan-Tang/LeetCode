

import java.util.*;

public class solution1002 {
    public List<String> commonChars(String[] A) {
        List<String> res = new LinkedList<>();
        if (A == null || A.length < 1) {
            return res;
        }
        int[] count = new int[26];
        for (int i = 0; i < A[0].length(); i++) {
            count[A[0].charAt(i) - 'a']++;
        }
        for (String curString : A) {
            int[] temp = new int[26];
            for (int i = 0; i < curString.length(); i++) {
                temp[curString.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                count[i] = count[i] < temp[i] ? count[i] : temp[i];
            }
        }
        for (int i = 0; i < 26; i++) {
            while (count[i] != 0) {
                count[i]--;
                Character c = (char) (i + 'a');
                res.add(c.toString());
            }
        }
        return res;
    }
}