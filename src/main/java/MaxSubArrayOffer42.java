/**
 * 剑指 Offer 42. 连续子数组的最大和
 * easy
 * 同53
 *
 * @author avatarannappa
 * @version 1.0, 2021/6/22
 */
public class MaxSubArrayOffer42 {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i : dp) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new MaxSubArrayOffer42().maxSubArray(nums));
    }
}
