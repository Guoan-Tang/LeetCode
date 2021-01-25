package LeetCode;

public class solution43 {
    public String multiply(String num1, String num2) {
        if (num1.length() < 1 || num2.length() < 1) {
            return "";
        }
        char[] res = new char[num1.length() + num2.length()], num1C = num1.toCharArray(),
                num2C = num2.toCharArray(), calRes;
        int zeroIndex = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = '0';
        }
        for (int i = num2C.length - 1; i >= 0; i--) {
            calRes = mul(num1C, num2C[i], num2C.length - i - 1);
            add(res, calRes);
        }
        while (zeroIndex+1 < res.length && res[zeroIndex] == '0') {
            zeroIndex++;
        }
        return new String(res).substring(zeroIndex).toString();
    }

    public char[] mul(char[] nums, char num, int bits) {
        char[] res = new char[nums.length + 1 + bits], calRes;
        char carryNum = '0';
        for (int i = nums.length - 1; i >= 0; i--) {
            calRes = threeNum(nums[i], num, carryNum);
            res[i + 1] = calRes[1];
            carryNum = calRes[0];
        }
        res[0] = carryNum;
        for (int i = nums.length + 1; i < res.length; i++) {
            res[i] = '0';
        }
        return res;
    }

    public void add(char[] source, char[] target) {
        int gap = source.length - target.length;
        char[] calRes = new char[2];
        char carryNum = '0';
        for (int i = target.length - 1; i >= 0; i--) {
            calRes = threeNumAdd(source[i + gap], target[i], carryNum);
            carryNum = calRes[0];
            source[i + gap] = calRes[1];
        }
        while (carryNum != '0') {
            int i = gap - 1;
            calRes = twoNumAdd(source[i], carryNum);
            carryNum = calRes[0];
            source[i] = calRes[1];
        }
    }

    public char[] threeNumAdd(char num1, char num2, char carryNum) {
        int temp = (int) (num1 + num2 + carryNum - '0' - '0' - '0');
        char[] res = new char[2];
        res[1] = (char) (temp % 10 + '0');
        temp /= 10;
        res[0] = (char) (temp % 10 + '0');
        return res;
    }

    public char[] twoNumAdd(char num1, char carryNum) {
        int temp = (int) (num1 + carryNum - '0' - '0');
        char[] res = new char[2];
        res[1] = (char) (temp % 10 + '0');
        temp /= 10;
        res[0] = (char) (temp % 10 + '0');
        return res;
    }


    public char[] threeNum(char num1, char num2, char carryNum) {
        int resNum = (num1 - '0') * (num2 - '0') + (carryNum - '0');
        char[] res = new char[2];
        res[1] = (char) (resNum % 10 + '0');
        resNum /= 10;
        res[0] = (char) (resNum % 10 + '0');
        return res;
    }

    public char[] twoNum(char num1, char carryNum) {
        int resNum = num1 - '0' + carryNum - '0';
        char[] res = new char[2];
        res[1] = (char) (resNum % 10 + '0');
        resNum /= 10;
        res[0] = (char) (resNum % 10 + '0');
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new solution43().multiply("0", "0"));
    }



    // public String multiply(String num1, String num2) {
    // char[] ca1, ca2;
    // if (num1.length() >= num2.length()) {
    // ca1 = num1.toCharArray();
    // ca2 = num2.toCharArray();
    // } else {
    // ca1 = num2.toCharArray();
    // ca2 = num1.toCharArray();
    // }
    // int i1 = ca1.length-1, i2 = ca2.length-1;
    // char carryNum = '0';
    // char[] resTemp;
    // StringBuilder res = new StringBuilder();
    // while (i1 >= 0) {
    // if (i2 >= 0) {
    // // shorter still have number
    // resTemp = threeNum(ca1[i1--], ca2[i2--], carryNum);
    // } else {
    // resTemp = twoNum(ca1[i1--], carryNum);
    // }
    // carryNum = resTemp[0];
    // res.append(resTemp[1]);
    // }
    // return res.reverse().toString();
    // }
}
