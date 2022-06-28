import java.util.Arrays;

/**
 * 剑指 Offer II 091. 粉刷房子
 * medium
 *
 * @author avatarannappa
 * @date 2022/6/28
 */
public class MinCostOfferII091 {

    int w;
    int h;
    int[][] costs;
    int minCost = Integer.MAX_VALUE;

    public int minCost(int[][] costs) {
        // DP
        int[] dp = Arrays.copyOf(costs[0], 3);
        for (int i = 1; i < costs.length; i++) {
            int a = Math.min(dp[1] + costs[i][0], dp[2] + costs[i][0]);
            int b = Math.min(dp[0] + costs[i][1], dp[2] + costs[i][1]);
            int c = Math.min(dp[0] + costs[i][2], dp[1] + costs[i][2]);
            dp[0] = a;
            dp[1] = b;
            dp[2] = c;
        }
        Arrays.sort(dp);
        return dp[0];
    }

    public int minCostOld(int[][] costs) {
        // 回溯，超时
        w = costs[0].length;
        h = costs.length;
        this.costs = costs;

        for (int i = 0; i < w; i++) {
            backTracking(0, i, 0);
        }
        return minCost;
    }

    public void backTracking(int row, int col, int cost) {
        if (cost >= minCost) {
            return;
        }
        if (row == h) {
            minCost = Math.min(minCost, cost);
            return;
        }
        for (int i = 0; i < w; i++) {
            if (i != col) {
                backTracking(row + 1, i, cost + costs[row][col]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] costs = {
            {17, 2, 17},
            {16, 16, 5},
            {14, 3, 19}};
        // 10
        System.out.println(new MinCostOfferII091().minCost(costs));
    }

}
