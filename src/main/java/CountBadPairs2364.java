import java.util.HashMap;
import java.util.Map;

/**
 * 2364. 统计坏数对的数目.
 * medium
 *
 * @author avatarannappa
 * @version 2025/4/18
 */
public class CountBadPairs2364 {

    public long countBadPairs(int[] nums) {
        // 规律 + 乘法原理
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i] - i, map.getOrDefault(nums[i] - i, 0) + 1);
        }

        long ans = 0;

        long t = nums.length;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans += entry.getValue() * (t - entry.getValue());
            t -= entry.getValue();
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 3, 3};
        // 5
        System.out.println(new CountBadPairs2364().countBadPairs(nums));
    }
}
