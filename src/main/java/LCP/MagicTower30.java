package LCP;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * LCP 30. 魔塔游戏
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2024/2/6
 */
public class MagicTower30 {
    public int magicTower(int[] nums) {
        // 贪心+优先队列
        long sum = 1;
        long left = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            queue.add(num);
            sum += num;
            while (!queue.isEmpty() && sum <= 0) {
                int min = queue.poll();
                if (min >= 0) {
                    return -1;
                }
                sum -= min;
                left += min;
                step++;
            }
            if (sum <= 0) {
                return -1;
            }
        }
        return sum + left <= 0 ? -1 : step;
    }
}
