

public class solution557 {
    public String reverseWords(String s) {
        if (s.length() < 2) {
            return s;
        }
        char[] sc = s.toCharArray();
        boolean iniState = true;
        StringBuilder res = new StringBuilder();
        int left = 0;
        for (int i = 0; i < sc.length; i++) {
            if (iniState) {
                if (sc[i] == ' ') {
                    res.append(" ");
                } else {
                    left = i;
                    iniState = false;
                }
            } else {
                if (sc[i] == ' ') {
                    iniState = true;
                    for (int j = i - 1; j >= left; j--) {
                        res.append(sc[j]);
                    }
                    res.append(' ');
                }
            }
        }
        if (!iniState) {
            for (int j = sc.length - 1; j >= left; j--) {
                res.append(sc[j]);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.print(new solution557().reverseWords(""));
    }
}
