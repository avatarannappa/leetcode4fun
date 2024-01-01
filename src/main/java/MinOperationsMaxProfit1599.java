/**
 * 1599. 经营摩天轮的最大利润
 * medium
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2024/01/01
 */
public class MinOperationsMaxProfit1599 {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int ans = -1;
        int maxProfit = 0;
        int totalProfit = 0;
        int step = 0;
        int customerCount = 0;
        int n = customers.length;
        for (int i = 0; i < n; i++) {
            step++;
            customerCount += customers[i];
            int onBoardCount = Math.min(customerCount, 4);
            customerCount -= onBoardCount;
            totalProfit += boardingCost * onBoardCount - runningCost;
            if (totalProfit > maxProfit) {
                maxProfit = totalProfit;
                ans = step;
            }
        }
        if (customerCount == 0) {
            return ans;
        }
        // 满员转亏钱，肯定赚不了
        int profitEachTime = boardingCost * 4 - runningCost;
        if (profitEachTime <= 0) {
            return ans;
        }
        int fullTimes = customerCount / 4;
        totalProfit += profitEachTime * fullTimes;
        step += fullTimes;
        if (totalProfit > maxProfit) {
            maxProfit = totalProfit;
            ans = step;
        }
        int remainingCustomers = customerCount % 4;
        int remainingProfit = boardingCost * remainingCustomers - runningCost;
        totalProfit += remainingProfit;
        if (totalProfit > maxProfit) {
            maxProfit = totalProfit;
            step++;
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] customers = {10,10,1,0,0};
        int boardingCost = 4;
        int runningCost = 4;
        System.out.println(new MinOperationsMaxProfit1599().minOperationsMaxProfit(
                customers, boardingCost, runningCost));
    }
}
