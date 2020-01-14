/**
 * 买卖股票最佳时机.
 *
 * @author avatarannappa
 * @version 1.0, 2019/1/14
 */
public class MaxProfit {

    public static int maxProfit(int[] prices) {
        /*
        * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
        * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
        * 注意你不能在买入股票前卖出股票。
        * */
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

    public static int maxProfitBetter(int[] prices) {
        Integer maxProfit = 0;
        Integer min = prices[0];
        Integer minIndex = 0;
        Integer max = prices[0];
        Integer maxIndex = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                minIndex = i;
            }
            if (prices[i] > max) {
                max = prices[i];
                maxIndex = i;
            }
        }
        maxProfit = max - min;
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfitBetter(prices));
    }
}
