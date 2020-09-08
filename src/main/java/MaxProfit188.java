/**
 * 188. 买卖股票的最佳时机 IV.
 *
 * @author avatarannappa
 * @version 1.0, 2020/9/8
 */
public class MaxProfit188 {

    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        // 内存超出限制优化，如果交易次数很多，当成无限交易
        if (k >= n / 2) {
            int dp0 = 0, dp1 = -prices[0];
            for (int i = 1; i < n; ++i) {
                int tmp = dp0;
                dp0 = Math.max(dp0, dp1 + prices[i]);
                dp1 = Math.max(dp1, tmp - prices[i]);
            }
            return dp0;
        }
        //定义三维数组，第i天、交易了多少次、当前的买卖状态
        int[][][] dp = new int[n][k + 1][2];
        //初始化第一天，这里的dp[0][k][1]可以不用管，后面也不会用到
        for (int i = 0; i <= k; ++i) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j <= k; ++j) {
                //处理第k次卖出
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                //处理第k次买入
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }

}
