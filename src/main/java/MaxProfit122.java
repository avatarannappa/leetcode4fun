/**
 * 122. 买卖股票的最佳时机 II
 *
 * @author avatarannappa
 * @version 1.0, 2020/1/24
 */
public class MaxProfit122 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int gap = prices[i+1] - prices[i];
            if (gap > 0) {
                profit = profit + gap;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        System.out.println(new MaxProfit122().maxProfit(nums));
    }
}
