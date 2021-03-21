public class solutionJ56_2 {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        for (int n : nums) {
            int cursor = 1;
            for (int i = 0; i < 32; i++) {
                if ((cursor & n) != 0) {
                    count[31 - i] = (count[31 - i] + 1) % 3;
                }
                cursor <<= 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (count[i] != 0) {
                res |= 1;
            }
            if (i != 31) {
                res <<= 1;
            }
        }
        return res;
    }
}
