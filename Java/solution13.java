import java.util.*;

public class solution13 {
    public int romanToInt(String s) {
        char[] sc = s.toCharArray();
        int res = 0;
        for (int i = 0; i < sc.length; i++) {
            switch (sc[i]) {
            case 'I':
                if (i < sc.length - 1) {
                    if (sc[i + 1] == 'V') {
                        res += 4;
                        i++;
                    } else if (sc[i + 1] == 'X') {
                        res += 9;
                        i++;
                    } else {
                        res++;
                    }
                } else {
                    res++;
                }
                break;
            case 'V':
                res += 5;
                break;
            case 'X':
                if (i < sc.length - 1) {
                    if (sc[i + 1] == 'L') {
                        res += 40;
                        i++;
                    } else if (sc[i + 1] == 'C') {
                        res += 90;
                        i++;
                    } else {
                        res += 10;
                    }
                } else {
                    res += 10;
                }
                break;
            case 'L':
                res += 50;
                break;
            case 'C':
                if (i < sc.length - 1) {
                    if (sc[i + 1] == 'D') {
                        res += 400;
                        i++;
                    } else if (sc[i + 1] == 'M') {
                        res += 900;
                        i++;
                    } else {
                        res += 100;
                    }
                } else {
                    res += 100;
                }
                break;
            case 'D':
                res += 500;
                break;
            case 'M':
                res += 1000;
            }
        }
        return res;
    }
}
