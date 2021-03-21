public class solution58 {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        boolean space = true;
        int startIndex = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (space) {
                if (s.charAt(i) == ' ') {
                    continue;
                } else {
                    startIndex = i;
                    space = false;
                }
            } else {
                if (s.charAt(i) == ' ') {
                    return startIndex - i;
                } else {
                    continue;
                }
            }
        }
        if (!space) {
            return startIndex + 1;
        }
        return 0;
    }
}
