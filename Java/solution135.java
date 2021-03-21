public class solution135 {
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        for (int i = 0; i < left.length; i++) {
            left[i] = 1;
        }
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        int res = left[ratings.length - 1], tempCandy = res;
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                tempCandy = (tempCandy + 1) > left[i] ? (tempCandy + 1) : left[i];
            } else {
                tempCandy = left[i];
            }
            res += tempCandy;
        }
        return res;
    }
}
