import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146. LRU缓存机制(Least Recently Used最近最少使用)。
 * 双向链表+hashmap，实现中间元素的O(1)插入，链表的前一个节点不用重新遍历
 *
 * @author avatarannappa
 * @version 1.0, 2020/4/12
 */
public class LRUCache146 {

    private MyMap m;

    public static class MyMap extends LinkedHashMap<Integer, Integer> {

        private int capacity;

        public MyMap(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }

    public LRUCache146(int capacity) {
        m = new MyMap(capacity);
    }

    public int get(int key) {
        return m.get(key);
    }

    public void put(int key, int value) {
        m.put(key, value);
    }

}
