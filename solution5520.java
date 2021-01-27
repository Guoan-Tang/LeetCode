

import java.util.*;

public class solution5520 {
    private HashSet<String> set;
    private int res;

    public int maxUniqueSplit(String s) {
        char[] sc = s.toCharArray();
        set = new HashSet<>();
        res = 0;
        dfsB(sc, 0);
        return res;
    }

    public boolean dfs(char[] sc, int startIndex) {
        if (startIndex >= sc.length) {
            return true;
        }
        for (int i = 1; i <= sc.length - startIndex; i++) {
            String temp = new String(sc, startIndex, i);
            if (!set.contains(temp)) {
                // 未包含
                // 加入集合中
                set.add(temp);
                if (dfs(sc, startIndex + i)) {
                    return true;
                } else {
                    set.remove(temp);
                }
            }
        }
        return false;
    }

    public void dfsB(char[] sc, int startIndex) {
        if (startIndex >= sc.length) {
            if (set.size() > res) {
                res = set.size();
            }
            return;
        }
        for (int i = 1; i <= sc.length - startIndex; i++) {
            String temp = new String(sc, startIndex, i);
            if (!set.contains(temp)) {
                // 未包含
                // 加入集合中
                set.add(temp);
                dfsB(sc, startIndex + i);
                set.remove(temp);
            }
        }
    }
}