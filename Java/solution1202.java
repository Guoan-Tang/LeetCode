import java.util.*;

public class solution1202 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (s == null || s.length() < 1 || pairs.size() < 1) {
            return s;
        }

        char[] sc = s.toCharArray();
        int[] father = new int[s.length()];
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }
        for (List<Integer> pair : pairs) {
            merge(pair.get(0), pair.get(1), father);
        }

        HashMap<Integer, Queue<Character>> map = new HashMap<>();
        for (int i = 0; i < sc.length; i++) {
            if (map.containsKey(findFather(i, father))) {
                map.get(findFather(i, father)).add(sc[i]);
            } else {
                map.put(findFather(i, father), new PriorityQueue<Character>((a, b)->a - b));
                map.get(findFather(i, father)).add(sc[i]);
            }
        }
        for (int i = 0; i < sc.length; i++) {
            System.out.print(findFather(i, father));
            sc[i] = map.get(findFather(i, father)).poll();
        }
        return new String(sc);
    }

    private int findFather (int sun, int[] father) {
        if (sun == father[sun]) {
            return sun;
        } else {
            father[sun] = findFather(father[sun], father);
            return father[sun];
        }
    }

    private void merge (int sun0, int sun1, int[] father) {
        if (findFather(sun0, father) != findFather(sun1, father)) {
            father[findFather(sun0, father)] = findFather(sun1, father);
        }
    }
}