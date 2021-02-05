public class solution1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] cost = new int[s.length()];
        for (int i = 0; i < cost.length; i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int l = 0, r = 0, sum = 0;
        while(r < cost.length) {
            sum += cost[r++];
            if (sum > maxCost) {
                sum -= cost[l++];
            }
        }
        return r - l;
    }
}
