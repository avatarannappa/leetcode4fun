import java.util.HashSet;
import java.util.Set;

/**
 * 3375. 使数组的值全部为 K 的最少操作次数.
 * easy
 *
 * @author avatarannappa
 * @version 2025/4/9
 */
public class MinOperations3375 {

    public int minOperations(int[] nums, int k) {
        // 一次遍历
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num < k) {
                return -1;
            }
            if (!set.contains(num)) {
                ans++;
                set.add(num);
            }
        }
        if (set.contains(k)) {
            ans--;
        }
        return ans;
    }

}
