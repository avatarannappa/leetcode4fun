import java.util.HashMap;
import java.util.Map;

/**
 * 1814. 统计一个数组中好对子的数目
 * medium
 *
 * @author avatarannappa
 * @date 2023/1/17
 */
public class CountNicePairs1814 {

    public int countNicePairs(int[] nums) {
        // 等式。O(n)
        int ans = 0;
        int MOD = 1000000007;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int reverseNum = 0;
            int tempNum = num;
            while (tempNum > 0) {
                reverseNum = reverseNum * 10 + tempNum % 10;
                tempNum /= 10;
            }
            int def = num - reverseNum;
            ans = (ans + map.getOrDefault(def, 0)) % MOD;
            map.put(def, map.getOrDefault(def, 0) + 1);
        }

        return ans;
    }

    public int countNicePairsOld(int[] nums) {
        // 模拟，O(n^^2)，超时
        int MOD = 1000000007;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int reverseNum = 0;
            int tempNum = num;
            while (tempNum > 0) {
                reverseNum = reverseNum * 10 + tempNum % 10;
                tempNum /= 10;
            }
            map.put(num, reverseNum);
        }

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int a = nums[i] + map.get(nums[j]) % MOD;
                int b = map.get(nums[i]) + nums[j] % MOD;
                ans += a == b ? 1 : 0;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {42, 11, 1, 97};
        // 2
        System.out.println(new CountNicePairs1814().countNicePairs(nums));
    }
}
