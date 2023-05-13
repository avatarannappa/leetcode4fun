import java.util.HashSet;
import java.util.Set;

/**
 * 2441. 与对应负数同时存在的最大正整数
 * eay
 *
 * @author avatarannappa
 * @version 1.0, 2023/5/13
 */
public class FindMaxK2442 {

    public int findMaxK(int[] nums) {
        // 模拟
        Set<Integer> set = new HashSet<>();
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num < 0) {
                set.add(-num);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > 0 && set.contains(num) && num > ans) {
                ans = num;
            }
        }
        return ans;
    }
}
