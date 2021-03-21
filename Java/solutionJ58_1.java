public class solutionJ58_1 {
    public String reverseWords(String s) {
        char[] sc = s.toCharArray();
        StringBuilder res = new StringBuilder();
        int l = sc.length - 1, r = l;
        boolean isWord = false;
        while (l >= 0) {
            if (sc[l] == ' ' && isWord) {
                for (int i = l + 1; i <= r; i++) {
                    res.append(sc[i]);
                }
                res.append(' ');
                isWord = false;
            } else if (sc[l] != ' ' && !isWord) {
                r = l;
                isWord = true;
            }
            l--;
        }
        if (isWord) {
            for (int i = l + 1; i <= r; i++) {
                res.append(sc[i]);
            }
        } else if (res.length() > 0) {
            res.deleteCharAt(res.length() - 1);
        }
        return res.toString();
    }
}
