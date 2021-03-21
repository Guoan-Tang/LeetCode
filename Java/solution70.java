public class solution70 {
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int a = 1, b = 2, c;
        while (n != 2) {
            n--;
            c = b;
            b = a + b;
            a = c;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(new solution70().climbStairs(45));
    }
}