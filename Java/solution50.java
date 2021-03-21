

public class solution50 {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        boolean Negative = false, Minimum = false;
        double temp = 1, res = 1;
        if (n < 0) {
            Negative = true;
            if (n == Integer.MIN_VALUE) {
                Minimum = true;
                temp = x;
                n = Integer.MAX_VALUE;
            } else {
                n = -n;
            }
        }
        while (n != 0) {
            if ((n & 1) == 1) {
                res *= x;
            }
            x *= x;
            n >>= 1;
        }
        if (Negative) {
            if (Minimum) {
                return 1 / (res * temp);
            }
            return 1 / res;
        } else {
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.print(new solution50().myPow(-1, Integer.MIN_VALUE));
    }
}
