package LeetCode;

import java.util.HashMap;

public class solution3 {
    private HashMap<Character, Boolean> rec;

    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        char[] sc = s.toCharArray();
        rec = new HashMap<Character, Boolean>();
        int left = 0, right = 1, res = 1;
        rec.put(sc[left], true);
        while (left < s.length() - res) {
            while (right < s.length()
                    && (rec.containsKey(sc[right]) == false || rec.get(sc[right]) == false)) {
                rec.put(sc[right], true);
                right++;
            }
            if (right - left > res) {
                res = right - left;
            }
            rec.put(sc[left], false);
            left += 1;
        }
        return res;
    }
}
