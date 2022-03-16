import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 432. 全 O(1) 的数据结构.
 * hard
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/3/16
 */
public class AllOne432 {

    Map<String, Node> map = new HashMap<>();
    public static Node root;

    public AllOne432() {
        // 哨兵，循环双向链表
        root = new Node();
        root.prev = root;
        root.next = root;
    }

    public void inc(String key) {
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            if (cur.next.equals(root) || cur.next.count > cur.count + 1) {
                map.put(key, cur.insert(new Node(key, cur.count + 1)));
            } else {
                cur.next.keys.add(key);
                map.put(key, cur.next);
            }
            cur.keys.remove(key);
            if (cur.keys.isEmpty()) {
                cur.remove();
            }
        } else {
            if (root.next == root || root.next.count > 1) {
                map.put(key, root.insert(new Node(key, 1)));
            } else {
                root.next.keys.add(key);
                map.put(key, root.next);
            }
        }
    }

    public void dec(String key) {
        Node cur = map.get(key);
        if (cur.count - 1 == 0) {
            map.remove(key);
        } else {
            Node newNode = new Node(key, cur.count - 1);
            if (cur.prev == root || cur.prev.count < cur.count - 1) {
                map.put(key, cur.prev.insert(newNode));
            } else {
                cur.prev.keys.add(key);
                map.put(key, cur.prev);
            }
        }
        cur.keys.remove(key);
        if (cur.keys.isEmpty()) {
            cur.remove();
        }
    }

    public String getMaxKey() {
        return root.prev.keys.iterator().next();
    }

    public String getMinKey() {
        return root.next.keys.iterator().next();
    }

    private static class Node {

        Set<String> keys;
        int count;
        Node prev;
        Node next;

        public Node() {
            this("", 0);
        }

        public Node(String key, int count) {
            this.count = count;
            keys = new HashSet<>();
            keys.add(key);
        }

        public Node insert(Node node) {
            // 在 this 后插入 node
            node.prev = this;
            node.next = this.next;
            node.prev.next = node;
            node.next.prev = node;
            return node;
        }

        public void remove() {
            this.prev.next = this.next;
            this.next.prev = this.prev;
        }

    }

}
