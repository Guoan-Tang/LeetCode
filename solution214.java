package LeetCode;

public class solution214 {
    public String shortestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        // construct s array and reversed s array
        char[] sArray = s.toCharArray(), sReverseArray = new char[s.length()];
        for (int i = sArray.length - 1; i >= 0; i--) {
            sReverseArray[i] = sArray[sArray.length - 1 - i];
        }

        // construct the longest and prefix suffix array
        int[] lps = new int[sArray.length];
        lps[0] = 0;
        int index = 1, len = 0;
        while (index < sArray.length) {
            if (sArray[index] == sArray[len]) {
                len++;
                lps[index] = len;
                index++;
            } else {
                if (len != 0) {
                    // the size of longest prefix and suffix between sArray[0]-sArray[i-1]!=0
                    len = lps[len - 1];
                } else {
                    // current char didnt match and pre lps was 0
                    lps[index] = 0;
                    index++;
                }
            }
        }

        // kmp search
        int searchIndex = 0, patternIndex = 0;
        while (searchIndex < sReverseArray.length) {
            if (sReverseArray[searchIndex] == sArray[patternIndex]) {
                // current char is matched compared next char
                searchIndex++;
                patternIndex++;
            } else {
                // current char is not matched
                if (patternIndex != 0) {
                    // is not the begin position in patternIndex
                    patternIndex = lps[patternIndex - 1];
                } else {
                    // to find next searchString
                    searchIndex++;
                }
            }
        }
        patternIndex--;


        // patternIndex is the left index of plalindrome subString
        // so append the remain string by seversed order to get answer
        StringBuilder res = new StringBuilder();
        for (int i = sArray.length - 1; i > patternIndex; i--) {
            res.append(sArray[i]);
        }
        for (int i = 0; i < sArray.length; i++) {
            res.append(sArray[i]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.print(new solution214().shortestPalindrome("aacecaaa"));
    }
}
