public class solution509 {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0, b = 1, res = -1;
        for (int i = 1; i < n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }

    public int rec(int n) {
        if (n <= 1) {
            return n;
        }
        return rec(n - 1) + rec(n - 2);
    }
}
