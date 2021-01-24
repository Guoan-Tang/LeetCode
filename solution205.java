import java.util.HashMap;
import java.util.HashSet;

public class solution205 {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        char a, b;
        for (int i = 0; i < s.length(); i++) {
            a = s.charAt(i);
            b = t.charAt(i);
            if (map.containsKey(a)) {
                if (map.get(a) != b) {
                    return false;
                }
            } else {
                if (set.contains(b)) {
                    return false;
                }
                set.add(b);
                map.put(a, b);
            }
        }
        return true;
    }
}
