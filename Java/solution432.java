

import java.util.*;

public class solution432 {
    class AllOne {
        private HashMap<String, Node> map;
        private Node head;
        private Node tail;

        /** Initialize your data structure here. */
        public AllOne() {
            map = new HashMap<>();
        }

        /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
        public void inc(String key) {
            Node curNode = map.get(key);
            if (curNode == null) {
                curNode = new Node(key, 1);
                map.put(key, curNode);
                if (head == null) {
                    head = curNode;
                    tail = curNode;
                } else {
                    tail.next = curNode;
                    curNode.pre = tail;
                    tail = curNode;
                }
            } else {
                curNode.val++;
                if (curNode != head && curNode.pre.val < curNode.val) {
                    Node targetNode = curNode.pre;
                    while (targetNode != null && targetNode.val < curNode.val) {
                        targetNode = targetNode.pre;
                    }
                    if (curNode == tail) {
                        tail = curNode.pre;
                        tail.next = null;
                    } else {
                        curNode.pre.next = curNode.next;
                        curNode.next.pre = curNode.pre;
                    }
                    if (targetNode == null) {
                        curNode.next = head;
                        curNode.pre = null;
                        head.pre = curNode;
                        head = curNode;
                    } else {
                        curNode.next = targetNode.next;
                        curNode.pre = targetNode;
                        targetNode.next.pre = curNode;
                        targetNode.next = curNode;
                    }
                }
            }
        }

        /**
         * Decrements an existing key by 1. If Key's value is 1, remove it from the data
         * structure.
         */
        public void dec(String key) {
            Node curNode = map.get(key);
            if (curNode == null) {
                return;
            }
            curNode.val--;
            if (curNode.val == 0) {
                map.remove(key);
                if (head == curNode) {
                    if (tail == curNode) {
                        head = null;
                        tail = null;
                    } else {
                        head = head.next;
                        head.pre = null;
                    }
                } else if (tail == curNode) {
                    tail = tail.pre;
                    tail.next = null;
                } else {
                    curNode.pre.next = curNode.next;
                    curNode.next.pre = curNode.pre;
                }
            } else {
                if (curNode != tail && curNode.next.val > curNode.val) {
                    Node targetNode = curNode.next;
                    while (targetNode != null && targetNode.val > curNode.val) {
                        targetNode = targetNode.next;
                    }
                    if (curNode == head) {
                        head = curNode.next;
                        head.pre = null;
                    } else {
                        curNode.pre.next = curNode.next;
                        curNode.next.pre = curNode.pre;
                    }
                    if (targetNode == null) {
                        curNode.pre = tail;
                        curNode.next = null;
                        tail.next = curNode;
                        tail = curNode;
                    } else {
                        curNode.next = targetNode;
                        curNode.pre = targetNode.pre;
                        targetNode.pre.next = curNode;
                        targetNode.pre = curNode;
                    }
                }
            }
        }

        /** Returns one of the keys with maximal value. */
        public String getMaxKey() {
            return head == null ? "" : head.key;
        }

        /** Returns one of the keys with Minimal value. */
        public String getMinKey() {
            return tail == null ? "" : tail.key;
        }

        class Node {
            String key;
            int val;
            Node pre;
            Node next;

            public Node(String key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }
}
