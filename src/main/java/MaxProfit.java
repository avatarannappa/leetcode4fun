/**
 * 买卖股票最佳时机.
 *
 * @author avatarannappa
 * @version 1.0, 2019/1/14
 * @since 2021/09/18 DP
 */
public class MaxProfit {

    public static int maxProfit(int[] prices) {
        // DP 同1014. 最佳观光组合
        int min = prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            result = Math.max(result, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return result;
    }

    public static int maxProfitOld(int[] prices) {
        /*
         * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
         * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。 注意你不能在买入股票前卖出股票。
         */
        Integer maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                if (prices[j] - prices[i] > maxProfit) {
                    maxProfit = prices[j] - prices[i];
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        // 5
        System.out.println(maxProfit(prices));
    }
}
