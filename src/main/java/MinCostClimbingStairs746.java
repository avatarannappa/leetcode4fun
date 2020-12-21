/**
 * 746. 使用最小花费爬楼梯
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2020/12/21
 */
public class MinCostClimbingStairs746 {

    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }

        int[] dp = new int[cost.length + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        dp[dp.length - 1] = Math.min(dp[dp.length - 2], dp[dp.length - 3]);
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(new MinCostClimbingStairs746().minCostClimbingStairs(cost));
    }
}
