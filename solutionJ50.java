import java.util.*;

public class solutionJ50 {
    public char firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.computeIfPresent(c, (k, v) -> v + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) {
                return e.getKey();
            }
        }
        return ' ';
    }
}
