/**
 * 518. 零钱兑换 II,Coin Change 2. medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/10/13
 */
public class Change518 {
    public int change(int amount, int[] coins) {
        // DP
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int amount = 5;
        // 4
        System.out.println(new Change518().change(amount, coins));
    }
}
