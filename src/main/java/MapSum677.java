import java.util.HashMap;
import java.util.Map;

/**
 * 677. 键值映射.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/11/15
 */
public class MapSum677 {

    public MapSum677() {

    }

    Map<String, Integer> map = new HashMap<>();

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int ans = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer val = entry.getValue();
            if (key.startsWith(prefix)) {
                ans += val;
            }
        }
        return ans;
    }

}
