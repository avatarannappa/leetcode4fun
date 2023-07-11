/**
 * 1911. 最大子序列交替和
 * medium
 *
 * @author avatarannappa
 * @date 2023/7/11
 */
public class MaxAlternatingSum1911 {

    public long maxAlternatingSum(int[] nums) {
        // 动态规划
        int n = nums.length;
        long[][] dp = new long[n][2];
        // 0 偶数， 1 奇数
        dp[0][0] = nums[0];
        dp[0][1] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + nums[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] - nums[i], dp[i - 1][1]);
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 5, 3};
        // 输出：7
        System.out.println(new MaxAlternatingSum1911().maxAlternatingSum(nums));
    }
}
