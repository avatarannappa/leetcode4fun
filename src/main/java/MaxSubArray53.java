/**
 * 53. 最大子序和 easy
 * 
 * @author avatarannappa
 * @version 1.0, 2020/01/01
 * @since 2021/09/17 DP
 */
public class MaxSubArray53 {

    public int maxSubArray(int[] nums) {
        // DP O(n)
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] > 0 ? nums[i] + dp[i - 1] : nums[i];
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public int maxSubArrayOld(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i; j < nums.length; j++) {
                temp += nums[j];
                if (temp > max) {
                    max = temp;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(new MaxSubArray53().maxSubArray(nums));
    }
}
