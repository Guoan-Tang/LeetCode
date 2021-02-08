public class solutionJ44 {
    public int findNthDigit(int n) {
        if (n == 0) {
            return 0;
        }
        return recursive(n - 1, 1);
    }

    private int recursive(int n, int digit) {
        if (n / digit >= 9 * (int)Math.pow(10, digit - 1)) {
            return recursive(n - 9 * (int)Math.pow(10, digit - 1) * digit, digit + 1);
        } else {
            int num = (int)Math.pow(10, digit - 1), index = digit - n % digit - 1;
            num += (n / digit);
            while (index != 0) {
                num /= 10;
                index--;
            }
            return num % 10;
        }
    }

    public static void main(String[] args) {
        new solutionJ44().findNthDigit(1000000000);
    }
}
