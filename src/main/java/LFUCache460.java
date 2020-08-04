import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * 460. LFU缓存.
 *
 * @author avatarannappa
 * @version 1.0, 2020/8/4
 */
public class LFUCache460 {

    Map<Integer, Node> m;
    Map<Integer, LinkedHashSet<Node>> l;
    int size;
    int capacity;
    int min;

    public LFUCache460(int capacity) {
        this.capacity = capacity;
        m = new HashMap<>(capacity);
        l = new HashMap<>();
    }

    public int get(int key) {
        Node node = m.get(key);
        if (node == null) {
            return -1;
        }
        inc(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = m.get(key);
        if (node != null) {
            node.value = value;
            inc(node);
        } else {
            if (size == capacity) {
                Node removeNode = removeNode();
                m.remove(removeNode.key);
                size--;
            }
            Node nodeNew = new Node(key, value);
            m.put(key, nodeNew);
            addNode(nodeNew);
            size++;
        }
    }

    void inc(Node node) {
        int frequency = node.frequency;
        LinkedHashSet<Node> set = l.get(frequency);
        set.remove(node);
        if (frequency == min && set.size() == 0) {
            min++;
        }

        node.frequency++;
        LinkedHashSet<Node> setNew = l.computeIfAbsent(node.frequency, k -> new LinkedHashSet<>());
        setNew.add(node);
    }

    void addNode(Node node) {
        LinkedHashSet<Node> set = l.computeIfAbsent(1, k -> new LinkedHashSet<>());
        set.add(node);
        min = 1;
    }

    Node removeNode() {
        LinkedHashSet<Node> set = l.get(min);
        Node node = set.iterator().next();
        set.remove(node);
        return node;
    }

    static class Node {
        /**
         * 缓存 key
         */
        private int key;

        /**
         * 缓存值
         */
        private int value;

        /**
         * 访问次数
         */
        private int frequency = 1;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
