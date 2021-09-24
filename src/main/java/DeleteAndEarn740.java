/**
 * 740. 删除并获得点数. medium
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2021/9/24
 */
public class DeleteAndEarn740 {

    public int deleteAndEarn(int[] nums) {
        // DP
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] temp = new int[max + 1];
        for (int num : nums) {
            temp[num] += num;
        }
        return rob(temp);
    }

    public int rob(int[] nums) {
        // 参考198. 打家劫舍
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 3, 3, 3, 4 };
        // 9
        System.out.println(new DeleteAndEarn740().deleteAndEarn(nums));
    }
}
