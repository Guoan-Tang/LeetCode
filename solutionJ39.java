public class solutionJ39 {
    public int majorityElement(int[] nums) {
        int votes = 0, num = -1;
        for (int i : nums) {
            if (votes == 0) {
                num = i;
                votes++;
            } else {
                if (i == num) {
                    votes++;
                } else {
                    votes--;
                }
            }
        }
        return num;
    }
}
