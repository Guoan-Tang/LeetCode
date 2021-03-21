

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class solution39 {
    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        dfs(candidates, new LinkedList<Integer>(), target, 0);
        return res;
    }

    public void dfs(int[] candidates, LinkedList<Integer> path, int target, int startIndex) {
        if (startIndex == candidates.length) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) {
            return;
        }
        if (candidates[startIndex] <= target) {
            path.add(candidates[startIndex]);
            dfs(candidates, path, target - candidates[startIndex], startIndex);
            path.removeLast();
        }
        dfs(candidates, path, target, startIndex + 1);
    }
}
