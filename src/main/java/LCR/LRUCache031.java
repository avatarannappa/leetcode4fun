package LCR;

import java.util.HashMap;
import java.util.Map;

/**
 * LCR 031. LRU 缓存
 * medium
 *
 * @author avatarannappa
 * @date 2023/11/15
 */
public class LRUCache031 {

    public static class Node {

        private int key;
        private int value;
        private Node prev;
        private Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }

    Node start;
    Node end;
    int capacity;
    Map<Integer, Node> map = new HashMap<>();
    int size = 0;

    public LRUCache031(int capacity) {
        this.capacity = capacity;
        start = new Node();
        end = new Node();
        start.next = end;
        end.prev = start;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        removeNode(node);
        addToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (map.containsKey(key)) {
            Node old = map.get(key);
            removeNode(old);
            addToHead(node);
        } else {
            addToHead(node);
            if (map.size() > capacity) {
                removeTail();
            }
        }
    }

    private void removeNode(Node node) {
        map.remove(node.key);
        size--;
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        map.put(node.key, node);
        size++;
        node.next = start.next;
        start.next.prev = node;
        start.next = node;
        node.prev = start;

    }

    private void removeTail() {
        Node tail = end.prev;
        removeNode(tail);
    }

}
