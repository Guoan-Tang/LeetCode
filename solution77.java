

import java.util.ArrayList;
import java.util.List;

public class solution77 {
    private List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        if (k > n || n < 1) {
            return res;
        }
        dfs(1, n, k, new ArrayList<Integer>());
        return res;
    }

    public void dfs(int begin, int end, int length, ArrayList<Integer> path) {
        if (path.size() == length) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = begin; i <= end - length + path.size() + 1; i++) {
            path.add(i);
            dfs(i + 1, end, length, path);
            path.remove(path.size() - 1);
        }
    }
}
