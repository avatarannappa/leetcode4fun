/**
 * 377. 组合总和 Ⅳ,Combination Sum IV. medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/10/14
 */
public class CombinationSumIV377 {

    public int combinationSum4(int[] nums, int target) {
        // DP 对比518，比埃氏筛多了组合,对比322
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        int target = 4;
        // 7
        System.out.println(new CombinationSumIV377().combinationSum4(nums, target));
    }
}
