import java.util.Arrays;

/**
 * 322. 零钱兑换.
 *
 * @author avatarannappa
 * @version 1.0, 2020/3/10
 */
public class CoinChange322 {

    int count = Integer.MAX_VALUE;
    int[] coins = null;

    public int coinChange(int[] coins, int amount) {
        // 超出时间限制
        Arrays.sort(coins);
        this.coins = coins;
        recursion(coins.length - 1, amount, 0);
        return count == Integer.MAX_VALUE ? -1 : count;
    }

    public void recursion(int index, int amount, int step) {
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
            recursion(index - 1, amount - i * coin, step + i);
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
        int[] coins = {288, 160, 10, 249, 40, 77, 314, 429};
        int amount = 9208;
        System.out.println(new CoinChange322().coinChange(coins, amount));
    }
}
