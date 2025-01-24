import java.util.HashSet;
import java.util.Set;

/**
 * 2944. 购买水果需要额最少金币数.
 * medium
 *
 * @author avatarannappa
 * @date 2025/1/24
 */
public class MinimumCoins2944 {

    int res = Integer.MAX_VALUE;
    Set<String> set = new HashSet<>();

    public int minimumCoins(int[] prices) {
        // 记忆化搜索
        recursion(prices, 0, 0, 0);
        return res;
    }

    public void recursion(int[] prices, int index, int total, int preIndex) {
        if (index == prices.length) {
            res = Math.min(res, total);
            return;
        }
        if (total >= res) {
            return;
        }
        if (set.contains(index + "-" + total + "-" + preIndex)) {
            return;
        }
        if (index + 1 <= preIndex * 2) {
            set.add(index + "-" + total + "-" + preIndex);
            recursion(prices, index + 1, total, preIndex);
        }
        set.add(index + "-" + total + "-" + preIndex);
        recursion(prices, index + 1, total + prices[index], index + 1);
    }

    public static void main(String[] args) {
        int[] prices = { 1, 10, 1, 1 };
        // 2
        System.out.println(new MinimumCoins2944().minimumCoins(prices));
    }
}
