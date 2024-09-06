import java.util.Arrays;

/**
 * 3176. 求出最长好子序列 I.
 * medium
 *
 * @author avatarannappa
 * @version 2024/9/6
 */
public class MaximumLength3176 {

    public int maximumLength(int[] nums, int k) {
        // DP
        int n = nums.length;
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
            for (int j = 0; j < k + 1; j++) {
                for (int m = 0; m < i; m++) {
                    int diff = nums[i] == nums[m] ? 0 : 1;
                    if (j - diff >= 0 && dp[m][j - diff] != -1) {
                        dp[i][j] = Math.max(dp[i][j], dp[m][j - diff] + 1);
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1, 3};
        int k = 2;
        // 4
        System.out.println(new MaximumLength3176().maximumLength(nums, k));
    }

}
