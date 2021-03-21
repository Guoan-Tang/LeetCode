
import java.util.*;

public class solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        LinkedList<Integer> res = new LinkedList<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int j : nums2) {
            if (set.contains(j)) {
                res.add(j);
                set.remove(j);
            }
        }
        int[] re = new int[res.size()];
        int index = 0;
        for (int i : res) {
            re[index++] = i;
        }
        return re;
    }
}