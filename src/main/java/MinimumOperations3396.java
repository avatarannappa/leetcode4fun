import java.util.HashSet;
import java.util.Set;

/**
 * 3396. 使数组元素互不相同所需的最少操作次数.
 * easy
 *
 * @author avatarannappa
 * @version 2025/4/8
 */
public class MinimumOperations3396 {

    public int minimumOperations(int[] nums) {
        // 倒序一次遍历
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = n - 1; i >= 0; i--) {
            if (set.contains(nums[i])) {
                return i / 3 + 1;
            }
            set.add(nums[i]);
        }
        return 0;
    }
}
