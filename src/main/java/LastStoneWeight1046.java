import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1046. 最后一块石头的重量
 * easy
 *
 * @author avatarannappa
 * @date 2023/1/17
 */
public class LastStoneWeight1046 {

    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            queue.offer(stone);
        }
        while (queue.size() > 1) {
            int x = queue.poll();
            int y = queue.poll();
            queue.offer(Math.abs(x - y));
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        // 1
        System.out.println(new LastStoneWeight1046().lastStoneWeight(stones));
    }
}
