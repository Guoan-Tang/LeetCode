public class solution1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int res = 0;
        if (dominoes == null) {
            return res;
        }
        int[] count = new int[100];
        for (int[] dominoe : dominoes) {
            int index = dominoe[0] > dominoe[1] ? (dominoe[0] + dominoe[1] * 10) : (dominoe[1] + dominoe[0] * 10);
            res += count[index];
            count[index]++;
        }
        return res;
    }
}