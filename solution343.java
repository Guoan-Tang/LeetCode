

public class solution343 {
    public int cuttingRope(int n) {
        if (n < 4) {
            return n - 1;
        }
        int e = n / 3, r = n % 3, result;
        if (r == 0) {
            result = pow(e);
        } else if (r == 1) {
            // long temp= pow(e-1);
            // temp*=4;
            // temp = temp % (long)(1e9+7);
            // result = (int) temp;
            result = ((((pow(e - 1) * 2) % ((int) (1e9 + 7))) * 2) % ((int) (1e9 + 7)));
        } else {
            result = (pow(e) * 2) % (int) (1e9 + 7);
        }
        return result;
    }

    public int pow(int e) {
        long res = 1, n = 3;
        while (e != 0) {
            if ((e & 1) == 1) {
                res = (res * n) % (int) (1e9 + 7);
            }
            n = (n * n) % (int) (1e9 + 7);
            e >>= 1;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.print(new solution343().cuttingRope(120));
    }
}
