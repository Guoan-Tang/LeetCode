

import java.util.*;

public class solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>(triangle.size());
        for (int i = 0; i < triangle.size(); i++) {
            dp.add(new ArrayList<>(triangle.get(i).size()));
        }
        dp.get(0).add(triangle.get(0).get(0));
        for (int layer = 1; layer < triangle.size(); layer++) {
            for (int index = 0; index < layer + 1; index++) {
                if (index == 0) {
                    dp.get(layer).add(dp.get(layer - 1).get(0) + triangle.get(layer).get(index));
                } else if (index == layer) {
                    dp.get(layer).add(dp.get(layer - 1).get(layer - 1) + triangle.get(layer).get(index));
                } else {
                    if (dp.get(layer - 1).get(index) > dp.get(layer - 1).get(index - 1)) {
                        dp.get(layer).add(triangle.get(layer).get(index) + dp.get(layer - 1).get(index - 1));
                    } else {
                        dp.get(layer).add(triangle.get(layer).get(index) + dp.get(layer - 1).get(index));
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.size(); i++) {
            if (dp.get(dp.size() - 1).get(i) < res) {
                res = dp.get(dp.size() - 1).get(i);
            }
        }
        return res;
    }
}
