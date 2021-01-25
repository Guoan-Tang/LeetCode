package LeetCode;

//import java.util.*;

public class solution844 {
    public boolean backspaceCompare(String S, String T) {
        int[] a = new int[S.length()], b = new int[T.length()];
        int aI = 0, bI = 0;
        char temp;
        for (int i = 0; i < S.length(); i++) {
            temp = S.charAt(i);
            if (temp == '#') {
                if (aI > 0) {
                    aI--;
                    a[aI] = 0;
                }
            } else {
                a[aI++] = (int) temp;
            }
        }
        for (int i = 0; i < T.length(); i++) {
            temp = T.charAt(i);
            if (temp == '#') {
                if (bI > 0) {
                    bI--;
                    b[bI] = 0;
                }
            } else {
                b[bI++] = (int) temp;
            }
        }
        if (aI != bI) {
            return false;
        }
        for (int i = 0; i < aI; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
