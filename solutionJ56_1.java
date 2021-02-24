public class solutionJ56_1 {
    public int[] singleNumbers(int[] nums) {
        int temp = 0, div = 1;
        for (int i : nums) {
            temp ^= i;
        }
        while ((div & temp) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int i : nums) {
            if ((i & div) != 0) {
                a ^= i;
            } else {
                b ^= i;
            }
        }
        return new int[]{a, b};
    }
}
