/**
 * 1567. 乘积为正数的最长子数组长度, Maximum Length of Subarray With Positive Product. medium
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2021/9/26
 */
public class GetMaxLen1567 {

    public int getMaxLen(int[] nums) {
        // 投机DP
        // 正反算一遍，我好懒。。 -7, -10, -7, 21 因为这种case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] revNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            revNums[nums.length - 1 - i] = nums[i];
        }
        return Math.max(fun(nums), fun(revNums));
    }

    public int fun(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0] > 0 ? 1 : 0;
        int result = dp[0];
        int index = nums[0] < 0 ? 0 : -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                dp[i] = 0;
                index = -1;
            } else if (nums[i] > 0) {
                if (nums[i - 1] < 0 && index >= 0) {
                    dp[i] = 1;
                } else {
                    dp[i] = dp[i - 1] + 1;
                }
            } else {
                if (index >= 0) {
                    dp[i] = i - 1 == index ? dp[i - 1] + 2 : dp[i - 1] + dp[index] + 2;
                    index = -1;
                } else {
                    dp[i] = dp[i - 1];
                    index = i;
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 5, -20, -20, -39, -5, 0, 0, 0, 36, -32, 0, -7, -10, -7, 21, 20, -12, -34, 26, 2 };
        System.out.println(new GetMaxLen1567().getMaxLen(nums));
    }
}
