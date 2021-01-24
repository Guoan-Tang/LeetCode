import java.util.*;

public class solution830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (s == null || s.length() < 3) {
            return res;
        }
        char[] c = s.toCharArray();
        for (int startIndex = 0; startIndex < c.length - 2; startIndex++) {
            int endIndex = startIndex;
            while (endIndex + 1 < c.length && c[endIndex + 1] == c[endIndex]) {
                endIndex++;
            }
            if (endIndex != startIndex) {
                if (endIndex - startIndex > 1) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(startIndex);
                    temp.add(endIndex);
                    res.add(temp);
                }
                startIndex = endIndex;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        solution830 s = new solution830();
        s.largeGroupPositions("abbxxxxzzy");
    }
}