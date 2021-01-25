package LeetCode;

public class solution393 {

    public static void main(String[] args) {
        int[] a = { 197, 130, 1 };
        new solution393().validUtf8(a);
    }

    public boolean validUtf8(int[] data) {
        if (data == null || data.length < 1 || data.length > 4) {
            return false;
        }
        boolean[][] inputs = convert(data);
        boolean[] temp = inputs[0];
        if (!temp[0]) {
            //0
            if (data.length != 1) {
                return false;
            }
        } else {
            //1
            if (temp[1]) {
                //11
                if (!temp[2]) {
                    //110
                    if (data.length != 2) {
                        return false;
                    }
                    if (!inputs[1][0]) {
                        return false;
                    }
                    if (inputs[1][1]) {
                        return false;
                    }
                } else {
                    if (!temp[3]) {
                        if (data.length != 3) {
                            return false;
                        }
                        if (!inputs[1][0] || !inputs[2][0]) {
                            return false;
                        }
                        if (inputs[1][1] || inputs[2][1]) {
                            return false;
                        }
                    } else {
                        if (temp[4]) {
                            return false;
                        }
                        if (data.length != 4) {
                            return false;
                        }
                        if (!inputs[1][0] || !inputs[2][0] || !inputs[3][0]) {
                            return false;
                        }
                        if (inputs[1][1] || inputs[2][1] || inputs[3][1]) {
                            return false;
                        }
                    }
                }
            } else {
                //10
                return false;
            }
        }
        return true;
    }

    public boolean[][] convert(int[] data) {
        boolean[][] res = new boolean[data.length][8];
        int num;
        for (int i = 0; i < data.length; i++) {
            num = data[i];
            for (int j = 0; j < 8; j++) {
                if ((num % 2) == 0) {
                    res[i][7 - j] = false;
                } else {
                    res[i][7 - j] = true;
                }
                num >>= 1;
            }
        }
        return res;
    }
}