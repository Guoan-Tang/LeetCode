import java.util.*;

public class solution399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        // construct the map which map name of node to number of node
        HashMap<String,Integer> map = new HashMap<>();
        int number = 0;
        for (List<String> eachEquation : equations) {
            if (!map.containsKey(eachEquation.get(0))) {
                map.put(eachEquation.get(0), number++);
            }
            if (!map.containsKey(eachEquation.get(1))) {
                map.put(eachEquation.get(1), number++);
            }
        }

        // construct the double dimensional array which describe the edges
        double[][] edges = new double[map.size()][map.size()];
        for (int i = 0; i < values.length; i++) {
            int startNum = map.get(equations.get(i).get(0)), endNum = map.get(equations.get(i).get(1));
            edges[startNum][endNum] = values[i];
            edges[endNum][startNum] = 1 / values[i];
        }

        // construct the answer
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0), b = queries.get(i).get(1);
            if (map.containsKey(a) && map.containsKey(b)) {
                int startNum = map.get(a), endNum = map.get(b);
                if (startNum == endNum) {
                    ans[i] = 1.0;
                } else if (edges[startNum][endNum] != 0) {
                    ans[i] = edges[startNum][endNum];
                } else {
                    Queue<Integer> nodeQueue = new LinkedList<>();
                    nodeQueue.offer(startNum);
                    double[] ratios = new double[map.size()];
                    Arrays.fill(ratios, -1.0);
                    ratios[startNum] = 1.0;
                    while (!nodeQueue.isEmpty() && ratios[endNum] < 0) {
                        int tempNum = nodeQueue.poll();
                        for (int j = 0; j < edges.length; j++) {
                            if (edges[tempNum][j] != 0 && ratios[j] < 0) {
                                nodeQueue.offer(j);
                                ratios[j] = ratios[tempNum] * edges[tempNum][j];
                            }
                        }
                    }
                    ans[i] = ratios[endNum];
                }
            } else {
                ans[i] = -1.0;
            }
        }

        return ans;
    }
}