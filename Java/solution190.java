public class solution190 {
    public class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int res = 0, cursor = 1;
            for (int i = 0; i < 31; i++) {
                if ((n & cursor) != 0) {
                    res += 1;
                }
                cursor <<= 1;
                res <<= 1;
            }
            if ((cursor & n) != 0) {
                res += 1;
            }
            return res;
        }
    }
}
