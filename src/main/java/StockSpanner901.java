import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 901. 股票价格跨度
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2022/10/21
 */
public class StockSpanner901 {

    public StockSpanner901() {

    }
    
    Deque<int[]> stack = new LinkedList<>();
    int index = 0;

    public int next(int price) {
        while (!stack.isEmpty() && stack.peek()[1] <= price) {
            stack.pop();
        }
        int pre = stack.isEmpty() ? 0 : stack.peek()[0];
        stack.push(new int[]{index++, price});
        return stack.size() == 1 ? index : index - pre - 1;
    }

    List<Integer> list = new LinkedList<>();
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    public int nextOld(int price) {
        // 超时
        list.add(price);
        if (price >= max) {
            max = Math.max(max, price);
            return list.size();
        } else if (price < min) {
            min = Math.min(min, price);
            return 1;
        }
        max = Math.max(max, price);
        min = Math.min(min, price);

        int ans = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) > price) {
                break;
            }
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        // 输入：["StockSpanner","next","next","next","next","next","next","next"]
        // [[],[100],[80],[60],[70],[60],[75],[85]]
        // 输出：[null,1,1,1,2,1,4,6]
        StockSpanner901 spanner901 = new StockSpanner901();
        int[] input = { 100, 80, 60, 70, 60, 75, 85 };
        for (int i : input) {
            System.out.println(spanner901.next(i));
        }
    }
}
