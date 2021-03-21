public class solution839 {
    private int res;

    public int numSimilarGroups(String[] strs) {
        res = strs.length;
        int[] f = new int[strs.length];
        for (int i = 0; i < f.length; i++) {
            f[i] = i;
        }
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (find(f, i) != find(f, j) && isSimilar(strs[i], strs[j])) {
                    f[find(f, i)] = f[find(f, j)];
                    res--;
                }
            }
        }
        return res;
    }

    private boolean isSimilar(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
                if (count >= 3) {
                    return false;
                }
            }
        }
        return true;
    }

    private int find(int[] f, int num) {
        if (f[num] != num) {
            f[num] = find(f, f[num]);
        }
        return f[num];
    }
}
