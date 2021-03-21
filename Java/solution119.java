import java.util.*;

public class solution119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        long curNum = 1;
        for (int i = 0; i <= rowIndex;) {
            res.add((int)curNum);
            i++;
            curNum *= (rowIndex - i + 1);
            curNum /= i;
        }
        return res;
    }
}
