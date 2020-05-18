import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 *
 * @author avatarannappa
 * @version 1.0, 2020/5/18
 */
public class SubArraySum560 {

    public int subarraySumPre(int[] nums, int k) {
        // 20ms 前缀和
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int t = sum - k;
            if (map.containsKey(t)) {
                int pre = map.get(t);
                count += pre;
            }

            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }
        return count;
    }

    public int subarraySum(int[] nums, int k) {
        // 386ms
        int count = 0;
        if (nums == null || nums.length == 0) {
            return count;
        }
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i; j < nums.length; j++) {
                temp += nums[j];
                if (temp == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(new SubArraySum560().subarraySumPre(nums, k));
    }
}
