import java.util.HashMap;
import java.util.Map;

/**
 * 2588. 统计美丽子数组数目.
 * medium
 *
 * @author avatarannappa
 * @version 2025/3/6
 * @see SubArraySum560
 */
public class BeautifulSubarrays2588 {

    public long beautifulSubarrays(int[] nums) {
        // O(n) 前缀和+哈希表
        int n = nums.length;
        long res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int pre = 0;
        for (int i = 0; i < n; i++) {
            pre ^= nums[i];
            if (map.containsKey(pre)) {
                res += map.get(pre);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return res;
    }

    public long beautifulSubarraysOld(int[] nums) {
        // O(n^2) 超时
        int n = nums.length;
        long res = 0;
        for (int i = 0; i < n; i++) {
            int t = 0;
            for (int j = i; j < n; j++) {
                t ^= nums[j];
                if (t == 0) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 1, 2, 4};
        System.out.println(new BeautifulSubarrays2588().beautifulSubarrays(nums));
    }
}
