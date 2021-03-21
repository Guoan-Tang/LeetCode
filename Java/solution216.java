

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class solution216 {
    private List<List<Integer>> res;
    private int size;

    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new LinkedList<>();
        size = k;
        if (n < 6) {
            return res;
        }
        dfs(new LinkedList<>(), 1, n);
        return res;
    }

    public void dfs(List<Integer> path, int start, int target) {
        if (target == 0 && path.size() == size) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (path.size() >= size) {
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (target < i) {
                return;
            }
            path.add(i);
            dfs(path, i+1, target - i);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new solution216().combinationSum3(3, 7));
    }
}
