/**
 * 2369. 检查数组是否存在有效划分
 * medium
 *
 * @author avatarannappa
 * @date 2024/3/1
 */
public class ValidPartition2369 {

    public boolean validPartition(int[] nums) {
        // 动态规划
        int n = nums.length;
        if (n < 2) {
            return false;
        } else if (n == 2) {
            return nums[0] == nums[1];
        }
        boolean[] dp = new boolean[n];
        dp[1] = nums[0] == nums[1];
        dp[2] = (nums[0] == nums[2] && nums[1] == nums[2]) || (nums[0] == nums[1] - 1 && nums[1] == nums[2] - 1);
        for (int i = 3; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                dp[i] |= dp[i - 2];
            }
            if ((nums[i] == nums[i - 1] && nums[i] == nums[i - 2])
                || (nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2)) {
                dp[i] |= dp[i - 3];
            }
        }
        return dp[n - 1];
    }

    public boolean validPartitionOld(int[] nums) {
        // 回溯，超时
        return traceBack(nums, 0, 1) || traceBack(nums, 0, 2);
    }

    public boolean traceBack(int[] nums, int l, int r) {
        if (l >= nums.length) {
            return true;
        }
        if (r >= nums.length) {
            return false;
        }
        if (r - l == 1) {
            if (nums[l] == nums[r]) {
                return traceBack(nums, r + 1, r + 2) || traceBack(nums, r + 1, r + 3);
            }
        } else {
            if (nums[l] == nums[l + 1] && nums[l] == nums[r]) {
                return traceBack(nums, r + 1, r + 2) || traceBack(nums, r + 1, r + 3);
            }
            if (nums[l] + 1 == nums[l + 1] && nums[l + 1] + 1 == nums[r]) {
                return traceBack(nums, r + 1, r + 2) || traceBack(nums, r + 1, r + 3);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{579611, 579611, 579611, 731172, 731172, 496074, 496074, 496074, 151416, 151416, 151416};
        // true;
        System.out.println(new ValidPartition2369().validPartition(nums));
    }
}
