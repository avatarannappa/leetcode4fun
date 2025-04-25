import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2845. 统计趣味子数组的数目.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2025/4/25
 */
public class CountInterestingSubarrays2845 {

    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        // 前缀和
        int n = nums.size();
        int[] sum = new int[n + 1];
        Map<Integer, Integer> cnt = new HashMap<>();
        cnt.put(0, 1);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + (nums.get(i) % modulo == k ? 1 : 0);
            ans += cnt.getOrDefault((sum[i + 1] - k + modulo) % modulo, 0);
            cnt.put(sum[i + 1] % modulo, cnt.getOrDefault(sum[i + 1] % modulo, 0) + 1);
        }

        return ans;
    }

}
