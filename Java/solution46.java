import java.util.*;

public class solution46 {
    private int[] candicates;
    private boolean[] hadSelected;
    List<List<Integer>> res;
    ArrayList<Integer> temp;

    public List<List<Integer>> permute(int[] nums) {
        candicates = nums;
        hadSelected = new boolean[nums.length];
        res = new LinkedList<>();
        temp = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            temp.add(-1);
        }
        core(0);
        return res;
    }

    private void core(int targetIndex) {
        if (targetIndex == candicates.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < candicates.length; i++) {
            if (!hadSelected[i]) {
                hadSelected[i] = true;
                temp.set(targetIndex, candicates[i]);
                core(targetIndex + 1);
                hadSelected[i] = false;
            }
        }
    }
}
