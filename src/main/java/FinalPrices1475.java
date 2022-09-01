import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 1475. 商品折扣后的最终价格
 * easy
 *
 * @author avatarannappa
 * @date 2022/9/1
 */
public class FinalPrices1475 {

    public int[] finalPrices(int[] prices) {
        // 暴力，模拟
        int[] ans = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= price) {
                    price -= prices[j];
                    break;
                }
            }
            ans[i] = price;
        }

        return ans;
    }

    public int[] finalPricesNew(int[] prices) {
        // 单调栈
        int n = prices.length;
        int[] ans = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && prices[deque.peekLast()] >= prices[i]) {
                int idx = deque.pollLast();
                ans[idx] = prices[idx] - prices[i];
            }
            deque.addLast(i);
            ans[i] = prices[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] prices = {8, 4, 6, 2, 3};
        // 输入：prices = [8,4,6,2,3]
        // 输出：[4,2,4,2,3]
        System.out.println(Arrays.toString(new FinalPrices1475().finalPrices(prices)));
    }
}
