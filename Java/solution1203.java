import java.util.*;

public class solution1203 {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        for (int i = 0; i < group.length; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] groupAdj = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            groupAdj[i] = new ArrayList<>();
        }
        @SuppressWarnings("unchecked")
        List<Integer>[] itemAdj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            itemAdj[i] = new ArrayList<>();
        }


        int[] groupAdjIndegree = new int[m];
        int[] itemAdjIndegree = new int[n];

        for (int i = 0; i < n; i++) {
            for (int beforeItem : beforeItems.get(i)) {
                if (group[beforeItem] != group[i]) {
                    groupAdj[group[beforeItem]].add(group[i]);
                    groupAdjIndegree[group[i]]++;
                }
                itemAdj[beforeItem].add(i);
                itemAdjIndegree[i]++;
            }
        }

        List<Integer> groupList = topologicalSort(groupAdj, groupAdjIndegree);
        if (groupList == null) {
            return new int[0];
        }
        List<Integer> itemList = topologicalSort(itemAdj, itemAdjIndegree);
        if (itemList == null) {
            return new int[0];
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (Integer i : itemList) {
            if (!map.containsKey(group[i])) {
                map.put(group[i], new LinkedList<>());
            }
            map.get(group[i]).add(i);
        }

        List<Integer> res = new LinkedList<>();
        for (Integer i : groupList) {
            List<Integer> items = map.getOrDefault(i, new ArrayList<>());
            res.addAll(items);
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    private List<Integer> topologicalSort(List<Integer>[] adj, int[] indegree) {
        List<Integer> res = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            res.add(cur);
            for (int tar : adj[cur]) {
                indegree[tar]--;
                if (indegree[tar] == 0) {
                    queue.offer(tar);
                }
            }
        }

        if (res.size() == indegree.length) {
            return res;
        }
        return null;
    }
}
