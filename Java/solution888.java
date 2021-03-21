import java.util.*;

public class solution888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int[] res = new int[2];
        int sum = 0;
        HashSet<Integer> mySet = new HashSet<>();
        for (int i : A) {
            sum += i;
            mySet.add(i);
        }
        for (int i : B) {
            sum -= i;
        }
        sum /= 2;
        for (int i : B) {
            if (mySet.contains(i + sum)) {
                res[0] = i + sum;
                res[1] = i;
                return res;
            }
        }
        return res;
    }
}
