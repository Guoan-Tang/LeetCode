public class solutionJ43 {
    public int countDigitOne(int n) {
        int cur = n % 10, low = 0, hight = n / 10, res = 0, digit = 1;
        while (hight != 0 || cur != 0) {
            if (cur == 1) {
                res += low + 1;
            } else if (cur > 1) {
                res += digit;
            }
            res += hight * digit;
            low += (digit * cur);
            cur = hight % 10;
            hight /= 10;
            digit *= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.print(new solutionJ43().countDigitOne(12));
    }
}
