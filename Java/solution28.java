

public class solution28 {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() < 1) {
            return 0;
        }
        return kmpMatchFunction(haystack, needle);
    }

    public int kmpMatchFunction(String target, String pattern) {
        if (pattern == null || target == null) {
            return -1;
        }
        char[] t = target.toCharArray(), p = pattern.toCharArray();
        int[] lps = buildLps(p);
        int x = 0, y = 0;
        while (x < t.length) {
            if (t[x] == p[y]) {
                x++;
                y++;
            } else if (y != 0) {
                y = lps[y - 1];
            } else {
                x++;
            }
            if (y == p.length) {
                return x - y;
            }
        }
        return -1;
    }

    public int[] buildLps(char[] t) {
        int[] res = new int[t.length];
        res[0] = 0;
        int length = 0;
        for (int i = 1; i < res.length; i++) {
            while (length > 0 && t[i] != t[length]) {
                length = res[length - 1];
            }
            if (t[length] == t[i]) {
                length++;
            }
            res[i] = length;
        }
        return res;
    }
}