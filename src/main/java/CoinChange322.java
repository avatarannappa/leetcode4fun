import java.util.Arrays;

/**
 * 322. 零钱兑换.
 *
 * @author avatarannappa
 * @version 1.0, 2020/3/10
 * @since 2021.09.23 DP O(n*coins.length)
 */
public class CoinChange322 {

    int count = Integer.MAX_VALUE;
    int[] coins = null;

    public int coinChange(int[] coins, int amount) {
        // DP 类似于埃氏筛，204题 质数，650题 两个键的键盘
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]]);
                }
            }
            dp[i] += 1;
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int coinChange1(int[] coins, int amount) {
        // 超出时间限制
        Arrays.sort(coins);
        this.coins = coins;
        recursion1(coins.length - 1, amount, 0);
        return count == Integer.MAX_VALUE ? -1 : count;
    }

    public void recursion1(int index, int amount, int step) {
        if (index < 0) {
            return;
        }
        int coin = coins[index];
        for (int i = amount / coin; i >= 0; i--) {
            int left = amount - i * coin;
            if (left == 0) {
                count = Math.min(count, step + i);
                break;
            }
            if (step + i > count) {
                break;
            }
            recursion1(index - 1, amount - i * coin, step + i);
        }
    }

    public int coinChangeOld(int[] coins, int amount) {
        // 超时
        Arrays.sort(coins);
        this.coins = coins;
        int index = coins.length - 1;
        int count = recursionOld(index, amount);
        return count;
    }

    public int recursionOld(int index, int amount) {
        if (amount == 0) {
            return 0;
        }
        int count = 0;
        int coin = coins[index];
        if (index == 0) {
            if (amount % coin == 0) {
                return amount / coin;
            } else {
                return -1;
            }
        } else {
            int min = -1;
            for (int i = 0; i <= amount; i = i + coin) {
                int temp = recursionOld(index - 1, amount - i);
                if (temp >= 0) {
                    min = min == -1 ? temp + count : Math.min(temp + count, min);
                }
                count++;
            }
            return min;
        }
    }

    public static void main(String[] args) {
        // int[] coins = { 288, 160, 10, 249, 40, 77, 314, 429 };
        // int amount = 9208;
        int[] coins = { 411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422 };
        int amount = 9864;
        System.out.println(new CoinChange322().coinChange(coins, amount));
    }
}
