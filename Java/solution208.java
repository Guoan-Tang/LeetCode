import java.util.*;

public class solution208 {
    class Trie {

        class node {
            HashMap<Character, node> map;
            boolean endPoint;
            node() {
                this.map = new HashMap<>();
                endPoint = false;
            }
        }

        HashMap<Character, node> map;

        /** Initialize your data structure here. */
        public Trie() {
            map = new HashMap<>();
        }
        
        /** Inserts a word into the trie. */
        public void insert(String word) {
            char[] c = word.toCharArray();
            HashMap<Character, node> curMap = map;
            int index = 0;
            node n = curMap.get(c[index]);
            while (index < c.length) {
                n = curMap.get(c[index]);
                if (n != null) {
                    curMap = n.map;
                    index++;
                } else {
                    break;
                }
            }
            while (index < c.length) {
                curMap.put(c[index], new node());
                n = curMap.get(c[index]);
                curMap = n.map;
                index++;
            }
            n.endPoint = true;
        }
        
        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            char[] c = word.toCharArray();
            HashMap<Character, node> curMap = map;
            int index = 0;
            node n = curMap.get(c[index]);
            while (index < c.length) {
                n = curMap.get(c[index]);
                if (n != null) {
                    curMap = n.map;
                    index++;
                } else {
                    break;
                }
            }
            return index == c.length && n.endPoint;
        }
        
        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            char[] c = prefix.toCharArray();
            int index = 0;
            node n;
            HashMap<Character, node> curMap = map;
            while (index < c.length) {
                n = curMap.get(c[index]);
                if (n != null) {
                    curMap = n.map;
                    index++;
                } else {
                    break;
                }
            }
            return index == c.length;
        }
    }
}
