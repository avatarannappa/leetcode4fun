/**
 * 2970. 统计移除递增子数组的数目 I
 * easy
 *
 * @author avatarannappa
 * @date 2024/7/10
 */
public class IncremovableSubarrayCount2970 {

    public int incremovableSubarrayCount(int[] nums) {
        // 简单模拟
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                ans += check(nums, i, j) ? 1 : 0;
            }
        }

        return ans;
    }

    private boolean check(int[] nums, int l, int r) {
        int pre = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i >= l && i <= r) {
                continue;
            }

            if (i == 0) {
                pre = nums[i];
                continue;
            }

            if (nums[i] <= pre) {
                return false;
            }

            pre = nums[i];
        }
        return true;
    }
}
