import java.util.*;

public class solutionJ48 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        char[] sc = s.toCharArray();
        int l = 0, r = 0, res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (r < sc.length) {
            while (map.containsKey(sc[r]) && map.get(sc[r]) > 0) {
                map.computeIfPresent(sc[l++], (k, v) -> v - 1);
            }
            map.putIfAbsent(sc[r], 0);
            map.computeIfPresent(sc[r], (k, v) -> v + 1);
            r++;
            res = Math.max(res, r - l);
        }
        return res;
    }
}