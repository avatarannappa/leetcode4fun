import java.util.Iterator;
import java.util.LinkedList;

/**
 * 706. 设计哈希映射.
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/3/16
 */
public class MyHashMap706 {

    private int hash = 769;
    private LinkedList<Tuple>[] l = new LinkedList[769];

    public static class Tuple {
        public int key;
        public int value;
    }

    /**
     * Initialize your data structure here.
     */
    public MyHashMap706() {
        for (int i = 0; i < l.length; i++) {
            l[i] = new LinkedList();
        }
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int index = hash(key);
        LinkedList<Tuple> list = l[index];
        for (int i = 0; i < list.size(); i++) {
            Tuple t = list.get(i);
            if (t.key == key) {
                t.value = value;
                return;
            }
        }
        Tuple newTuple = new Tuple();
        newTuple.key = key;
        newTuple.value = value;
        l[index].addLast(newTuple);
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int index = hash(key);
        LinkedList<Tuple> list = l[index];
        for (int i = 0; i < list.size(); i++) {
            Tuple t = list.get(i);
            if (t.key == key) {
                return t.value;
            }
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int index = hash(key);
        LinkedList<Tuple> list = l[index];
        Iterator<Tuple> iterator = l[index].iterator();
        while (iterator.hasNext()) {
            Tuple t = iterator.next();
            if (t.key == key) {
                iterator.remove();
                return;
            }
        }
    }

    private int hash(int key) {
        return key % hash;
    }
}
