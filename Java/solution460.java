import java.util.*;

public class solution460 {
    class LFUCache {
        class item implements Comparable<item>{
            int key;
            int value;
            int count;

            public item(int key, int value, int count) {
                this.key = key;
                this.value = value;
                this.count = count;
            }

            @Override
            public int compareTo(item target) {
                return count - target.count;
            }
        }

        ArrayList<item> items;
        HashMap<Integer, item> map;
        int count;

        public LFUCache(int capacity) {
            items = new ArrayList<>(capacity);
            map = new HashMap<>();
            count = capacity;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                item target = map.get(key);
                target.count++;
                return target.value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                item i = map.get(key);
                i.count++;
                Collections.sort(items);
            } else {
                if (count == 0) {
                    int lastKey = items.get(items.size() - 1).key;
                    map.remove(lastKey);
                    items.remove(items.size() - 1);
                    item newItem = new item(key, value, 1);
                    map.put(key, newItem);
                    items.add(newItem);
                } else {
                    item newItem = new item(key, value, 1);
                    map.put(key, newItem);
                    items.add(newItem);
                    count--;
                }
            }
        }
    }
}
