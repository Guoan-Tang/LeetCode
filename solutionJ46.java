import java.util.LinkedList;

public class solutionJ46 {
    public int translateNum(int num) {
        if (num < 10) {
            return 1;
        }
        LinkedList<Integer> list = new LinkedList<>();
        while (num != 0) {
            list.addFirst(num % 10);
            num /= 10;
        }
        int[] nc = new int[list.size()];
        int index = 0;
        for (int i : list) {
            nc[index++] = i;
        }
        int[] dp = new int[nc.length];
        dp[0] = 1;
        if (nc[0] == 1 || (nc[0] == 2 && nc[1] <= 5)) {
            dp[1] = 2;
        } else {
            dp[1] = 1;
        }
        for (int i = 2; i < nc.length; i++) {
            if (nc[i - 1] == 1 || (nc[i - 1] == 2 && nc[i] <= 5)) {
                dp[i] = dp[i - 2] + dp[i - 1];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }
}
