import java.util.*;

public class solution1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>(A.length);
        int temp = 0;
        for (int i = 0; i < A.length; i++) {
            temp = (temp * 2 + A[i]) % 5;
            if (temp == 0) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }
}
