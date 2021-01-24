public class solution67 {
    public String addBinary(String a, String b) {
        StringBuffer res = new StringBuffer();
        char[] A = a.toCharArray(), B = b.toCharArray();
        int i = 0;
        boolean extern = false;
        while (i < A.length && i < B.length) {
            if (extern) {
                if (A[A.length - 1 - i] == '0') {
                    if (B[B.length - 1 - i] == '0') {
                        res.append('1');
                        extern = false;
                    } else {
                        res.append('0');
                    }
                } else {
                    if (B[B.length - 1 - i] == '0') {
                        res.append('0');
                    } else {
                        res.append('1');
                    }
                }
            } else {
                if (A[A.length - 1 - i] == '0') {
                    if (B[B.length - 1 - i] == '0') {
                        res.append('0');
                    } else {
                        res.append('1');
                    }
                } else {
                    if (B[B.length - 1 - i] == '0') {
                        res.append('1');
                    } else {
                        res.append('0');
                        extern = true;
                    }
                }
            }
            i++;
        }
        while (i < A.length) {
            if (extern) {
                if (A[A.length - 1 - i] == '0') {
                    res.append('1');
                    extern = false;
                } else {
                    res.append('0');
                }
            } else {
                if (A[A.length - 1 - i] == '0') {
                    res.append('0');
                } else {
                    res.append('1');
                }
            }
            i++;
        }
        while (i < B.length) {
            if (extern) {
                if (B[B.length - 1 - i] == '0') {
                    res.append('1');
                    extern = false;
                } else {
                    res.append('0');
                }
            } else {
                if (B[B.length - 1 - i] == '0') {
                    res.append('0');
                } else {
                    res.append('1');
                }
            }
            i++;
        }
        if (extern) {
            res.append('1');
        }
        res.reverse();
        return res.toString();
    }
}
