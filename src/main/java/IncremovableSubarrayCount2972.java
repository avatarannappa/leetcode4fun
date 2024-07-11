/**
 * 2972. 统计移除递增子数组的数目 II
 * hard
 *
 * @author avatarannappa
 * @date 2024/7/11
 */
public class IncremovableSubarrayCount2972 {

    public long incremovableSubarrayCount(int[] nums) {
        // see 2970, 数据量大，非暴力
        // 双指针
        int n = nums.length;
        int l = 0;
        for (; l < n - 1; l++) {
            if (nums[l] >= nums[l + 1]) {
                break;
            }
        }
        if (l == n - 1) {
            // 整体单调递增，移除任意非空子数组都行
            return n * (n + 1L) / 2;
        }

        // 移除所有后缀
        long res = l + 2L;

        // 移除中间
        for (int r = n - 1; r == n - 1 || nums[r] < nums[r + 1]; r--) {
            while (l >= 0 && nums[l] >= nums[r]) {
                l--;
            }
            res += l + 2;
        }

        return res;
    }

}
