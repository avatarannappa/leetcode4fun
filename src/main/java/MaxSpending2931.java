import java.util.PriorityQueue;

/**
 * 2931. 购买物品的最大开销.
 * hard
 *
 * @author avatarannappa
 * @version 2024/12/12
 */
public class MaxSpending2931 {

    public long maxSpending(int[][] values) {
        // 贪心
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        int m = values.length;
        int n = values[0].length;
        for (int i = 0; i < m; i++) {
            int[] item = new int[3];
            item[0] = values[i][n - 1];
            item[1] = i;
            item[2] = n - 1;
            pq.offer(item);
        }

        long res = 0;
        long day = 1L;
        while (!pq.isEmpty()) {
            int[] item = pq.poll();
            res += item[0] * day;
            day++;
            if (item[2] > 0) {
                item[2]--;
                item[0] = values[item[1]][item[2]];
                pq.offer(item);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] values = { { 8, 5, 2 }, { 6, 4, 1 }, { 9, 7, 3 } };
        // 285
        System.out.println(new MaxSpending2931().maxSpending(values));
    }
}
