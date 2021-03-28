public class solution151 {
    public String reverseWords(String s) {
        if (s.length() < 1) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        boolean iniSta = true;
        char[] sc = s.toCharArray();
        int left = 0;
        for (int i = 0; i < sc.length; i++) {
            if (iniSta) {
                if (sc[i] != ' ') {
                    left = i;
                    iniSta = false;
                }
            } else {
                if (sc[i] == ' ') {
                    for (int j = i - 1; j >= left; j--) {
                        res.append(sc[j]);
                    }
                    res.append(' ');
                    iniSta = true;
                }
            }
        }
        if (iniSta) {
            if (res.length() >= 1)
                res.deleteCharAt(res.length() - 1);
        } else {
            for (int j = sc.length - 1; j >= left; j--) {
                res.append(sc[j]);
            }
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.print(new solution151().reverseWords(" "));
    }
}
