import java.util.*;

public class solutionJ45 {
    public String minNumber(int[] nums) {
        ArrayList<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        Collections.sort(list, new Comparator<String>(){
            @Override
            public int compare(String a, String b) {
                return (a + b).compareTo((b + a));
            }
        });
        StringBuffer res = new StringBuffer();
        for (String s : list) {
            res.append(s);
        }
        return res.toString();
    }
}
