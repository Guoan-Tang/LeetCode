public class solution922 {
    public int[] sortArrayByParityII(int[] A) {
        int[] res = new int[A.length];
        int evenIndex = 0, oddIndex = 1;
        for (int i : A) {
            if ((i % 2) == 0) {
                res[evenIndex] = i;
                evenIndex += 2;
            } else {
                res[oddIndex] = i;
                oddIndex += 2;
            }
        }
        return res;
    }
}
