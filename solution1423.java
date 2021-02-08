public class solution1423 {
    public int maxScore(int[] cardPoints, int k) {
        if (cardPoints == null || cardPoints.length < 1 || k > cardPoints.length) {
            return 0;
        }
        int sum = 0, index = 0;
        while (index < cardPoints.length - k) {
            sum += cardPoints[index++];
        }
        int res = sum, total = sum;
        while (index < cardPoints.length) {
            total += cardPoints[index];
            sum += cardPoints[index];
            sum -= cardPoints[index - cardPoints.length + k];
            if (sum <= res) {
                res = sum;
            }
            index++;
        }
        return total - res;
    }
}