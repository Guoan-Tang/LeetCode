import java.util.*;

public class solutionJ38 {
    private LinkedList<String> resTemp;

    public String[] permutation(String s) {
        if (s== null || s.length() < 1) {
            return null;
        }
        resTemp = new LinkedList<>();
        int[] chars = new int[26];
        StringBuilder sb = new StringBuilder();
        int resIndex = 0;
        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }
        core(sb, chars, s.length());
        String[] res = new String[resTemp.size()];
        for (String st : resTemp) {
            res[resIndex++] = st;
        }
        return res;
    }

    private void core(StringBuilder sb, int[] chars, int restCount) {
        if (restCount == 0) {
            resTemp.add(sb.toString());
        } else {
            for (int i = 0; i < 26; i++) {
                if (chars[i] != 0) {
                    chars[i]--;
                    sb.append((char)('a'+i));
                    core(sb, chars, restCount - 1);
                    sb.deleteCharAt(sb.length() - 1);
                    chars[i]++;
                }
            }
        }
    }
}