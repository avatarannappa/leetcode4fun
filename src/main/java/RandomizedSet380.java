import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 380. 常数时间插入、删除和获取随机元素
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/3/14
 */
public class RandomizedSet380 {

    Map<Integer, Integer> dict = new HashMap();
    List<Integer> list = new ArrayList();
    Random rand = new Random();

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet380() {

    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (dict.containsKey(val)) {
            return false;
        }
        dict.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!dict.containsKey(val)) {
            return false;
        }
        int index = dict.get(val);
        int lastVal = list.get(list.size() - 1);
        dict.put(lastVal, index);
        list.set(index, lastVal);
        dict.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
