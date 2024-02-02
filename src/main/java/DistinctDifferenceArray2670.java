import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 2670. 找出不同元素数目差数组
 * easy
 *
 * @author avatarannappa
 * @date 2024/2/2
 */
public class DistinctDifferenceArray2670 {

    public int[] distinctDifferenceArray(int[] nums) {
        // 哈希表，模拟
        Set<Integer> before = new HashSet<>();
        Map<Integer, Integer> after = new HashMap<>();
        for (int i : nums) {
            after.put(i, after.getOrDefault(i, 0) + 1);
        }

        int[] res = new int[nums.length];

        int index = 0;
        for (int i : nums) {
            before.add(i);
            after.put(i, after.get(i) - 1);
            if (after.get(i) == 0) {
                after.remove(i);
            }
            res[index++] = before.size() - after.size();
        }

        return res;
    }
}
