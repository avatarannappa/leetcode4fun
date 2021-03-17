import java.util.HashMap;
import java.util.Map;

/**
 * 220. 存在重复元素 III
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/3/17
 */
public class ContainsNearbyAlmostDuplicate220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // 桶思想
        Map<Long, Long> map = new HashMap<>();
        long gap = (long) t + 1;
        for (int i = 0; i < nums.length; i++) {
            long bucket = getBucket(nums[i], gap);
            if (map.containsKey(bucket)) {
                return true;
            }
            if (map.containsKey(bucket - 1) && Math.abs(nums[i] - map.get(bucket - 1)) <= t) {
                return true;
            }
            if (map.containsKey(bucket + 1) && Math.abs(nums[i] - map.get(bucket + 1)) <= t) {
                return true;
            }
            map.put(bucket, (long) nums[i]);
            if (i >= k) {
                long expireBucket = getBucket(nums[i - k], gap);
                map.remove(expireBucket);
            }
        }
        return false;
    }

    public long getBucket(long a, long b) {
        return a < 0 ? (a + 1) / b - 1 : a / b;
    }

    public boolean containsNearbyAlmostDuplicateOld(int[] nums, int k, int t) {
        // 超时
        if (nums == null || nums.length == 0) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length && j - i <= k; j++) {
                long ivalue = nums[i];
                long jvalue = nums[j];
                if (Math.abs(jvalue - ivalue) <= t) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 9, 1, 5, 9};
        int k = 2;
        int t = 3;
        System.out.println(new ContainsNearbyAlmostDuplicate220().containsNearbyAlmostDuplicate(nums, k, t));
    }
}
