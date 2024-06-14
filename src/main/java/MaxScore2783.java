/**
 * 2786. 访问数组中的位置使分数最大
 * medium
 *
 * @author avatarannappa
 * @date 2024/6/14
 */
public class MaxScore2783 {

    public long maxScore(int[] nums, int x) {
        // 状态压缩+dp，只考虑奇偶状态最大的
        // 缩短写法
        int n = nums.length;
        long[] dp = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        dp[nums[0] % 2] = nums[0];
        for (int i = 1; i < n; i++) {
            int now = nums[i];
            int sign = now % 2;
            dp[sign] = Math.max(dp[sign] + now, dp[1 - sign] + now - x);
        }
        return Math.max(dp[0], dp[1]);
    }

    public long maxScoreOld(int[] nums, int x) {
        int n = nums.length;
        long[] dp = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        if (nums[0] % 2 == 0) {
            dp[0] = nums[0];
        } else {
            dp[1] = nums[0];
        }
        for (int i = 1; i < n; i++) {
            int now = nums[i];
            int nowSign = now % 2;
            long even;
            long odd;
            if (nowSign == 0) {
                even = Math.max(dp[0] + now, dp[1] + now - x);
                odd = dp[1];
            } else {
                odd = Math.max(dp[1] + now, dp[0] + now - x);
                even = dp[0];
            }
            dp[0] = even;
            dp[1] = odd;
        }
        return Math.max(dp[0], dp[1]);
    }

    public static void main(String[] args) {
        int[] nums = {8, 50, 65, 85, 8, 73, 55, 50, 29, 95, 5, 68, 52, 79};
        int x = 74;
        // 470
        System.out.println(new MaxScore2783().maxScore(nums, x));
    }
}
