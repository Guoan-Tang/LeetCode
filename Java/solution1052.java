public class solution1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        // 求长度为X的区间内grumpy为1且customers的和最多的值
        // 同时加上满足 grumpy为0时customers中的值
        int res = 0, curSave = 0, maxSave = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 1) {
                // boss is angry
                curSave += customers[i];
            } else {
                res += customers[i];
            }
            if (i - X >= 0 && grumpy[i - X] == 1) {
                curSave -= customers[i - X];
            }
            maxSave = Math.max(curSave, maxSave);
        }
        return res + maxSave;
    }
}
