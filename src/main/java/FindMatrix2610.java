import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 2610. 转换二维数组.
 * medium
 *
 * @author avatarannappa
 * @version 2025/3/19
 */
public class FindMatrix2610 {

    public List<List<Integer>> findMatrix(int[] nums) {
        // 哈希表
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            max = Math.max(max, map.get(num));
        }

        List<List<Integer>> ans = new LinkedList<>();
        for (int i = 0; i < max; i++) {
            List<Integer> t = new LinkedList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > 0) {
                    map.put(entry.getKey(), entry.getValue() - 1);
                    t.add(entry.getKey());
                }
            }
            ans.add(t);
        }
        return ans;
    }
}
