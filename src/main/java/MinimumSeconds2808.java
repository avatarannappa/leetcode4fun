import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 2808. 使循环数组所有元素相等的最少秒数
 * medium
 *
 * @author avatarannappa
 * @date 2024/1/30
 */
public class MinimumSeconds2808 {

    public int minimumSeconds(List<Integer> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            List<Integer> list = map.getOrDefault(num, new ArrayList<>());
            list.add(i);
            map.put(num, list);
        }

        int min = n;
        for (Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> value = entry.getValue();
            if (value.size() == 1) {
                continue;
            }
            int max = Integer.MIN_VALUE;
            int m = value.size();
            for (int i = 0; i < m; i++) {
                int pre = (i - 1 + m) % m;
                int next = (i + 1) % m;
                int preIndex = value.get(pre);
                int nextIndex = value.get(next);
                max = Math.max(max, Math.max((value.get(i) - preIndex + n) % n, (nextIndex - value.get(i) + n) % n));
            }
            min = Math.min(min, max);
        }
        return min / 2;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(2, 1, 3, 3, 2);
        // 2
        System.out.println(new MinimumSeconds2808().minimumSeconds(nums));
    }
}
