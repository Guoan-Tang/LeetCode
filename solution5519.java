package LeetCode;

import java.util.LinkedList;

public class solution5519 {

    public static void main(String[] args) {
        System.out.println(new solution5519().reorderSpaces("  this   is  a sentence "));
    }

    public String reorderSpaces(String text) {
        boolean space = true;
        int spaceCount = 0, startIndex = 0;
        char[] sc = text.toCharArray();
        LinkedList<String> store = new LinkedList<>();
        for (int i = 0; i < sc.length; i++) {
            if (space) {
                if (sc[i] == ' ') {
                    spaceCount++;
                } else {
                    startIndex = i;
                    // gapCount++;
                    space = false;
                }
            } else {
                if (sc[i] == ' ') {
                    spaceCount++;
                    space = true;
                    store.add(new String(sc, startIndex, i - startIndex));
                }
            }
        }
        if (!space) {
            store.add(new String(sc, startIndex, sc.length - startIndex));
        }
        StringBuffer res = new StringBuffer();
        if (store.size() <= 1) {
            res.append(store.get(0));
            for (int i = 0; i < spaceCount; i++) {
                res.append(" ");
            }
            return res.toString();
        }
        int q = spaceCount / (store.size() - 1), r = spaceCount % (store.size() - 1);
        for (int i = 0; i < store.size(); i++) {
            res.append(store.get(i));
            if (i != store.size() - 1) {
                for (int j = 0; j < q; j++) {
                    res.append(" ");
                }
            }
        }
        for (int i = 0; i < r; i++) {
            res.append(" ");
        }
        return res.toString();
    }
}
