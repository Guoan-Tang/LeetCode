public class solution123 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int b1 = -prices[0], s1 = 0, b2 = -prices[0], s2 = 0;
        for (int i = 1; i < prices.length; i++) {
            b1 = Math.max(b1, -prices[i]);
            s1 = Math.max(s1, b1 + prices[i]);
            b2 = Math.max(b2, s1 - prices[i]);
            s2 = Math.max(s2, b2 + prices[i]);
        }
        return s2;
    }
}