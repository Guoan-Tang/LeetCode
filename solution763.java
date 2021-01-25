package LeetCode;

import java.util.*;

public class solution763 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new LinkedList<>();
        if (S == null) {
            return res;
        }
        int[] endIndex = new int[26];
        char[] c = S.toCharArray();
        for (int i = 0; i < 26; i++) {
            endIndex[i] = -1;
        }
        for (int i = 0; i < c.length; i++) {
            endIndex[c[i] - 'a'] = i;
        }
        int l = 0, r = 0, cur = 0;
        while (l < c.length) {
            while (cur <= r) {
                r = r > endIndex[c[cur] - 'a'] ? r : endIndex[c[cur] - 'a'];
                cur++;
            }
            res.add(r - l + 1);
            l = cur;
            r = cur;
        }
        return res;
    }
}
