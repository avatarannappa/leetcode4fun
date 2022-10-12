import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 502. IPO
 * hard
 * 
 * @author avatarannappa
 * @version 1.0, 2022/10/12
 */
public class FindMaximizedCapital502 {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // 贪心
        int n = profits.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        // 大顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int i = 0;
        for (; k > 0; k--) {
            for (; i < n && arr[i][0] <= w; i++) {
                queue.add(arr[i][1]);
            }

            if (queue.isEmpty()) {
                // 资本不够，进行不下去了
                break;
            }

            // w是递增的，queue中只要有数据就能用
            w += queue.poll();
        }

        return w;
    }

    public static void main(String[] args) {
        int k = 2;
        int w = 0;
        int[] profits = { 1, 2, 3 };
        int[] capital = { 0, 1, 1 };
        // 4
        System.out.println(new FindMaximizedCapital502().findMaximizedCapital(k, w, profits, capital));
    }
}