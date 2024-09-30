import java.util.PriorityQueue;

/**
 * 1845. 座位预约管理系统.
 * medium
 *
 * @author avatarannappa
 * @version 2024/9/30
 */
public class SeatManager1845 {

    private PriorityQueue<Integer> queue;

    public SeatManager1845(int n) {
        // 优先队列，堆
        queue = new PriorityQueue<>(n);
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
    }

    public int reserve() {
        return queue.poll();
    }

    public void unreserve(int seatNumber) {
        queue.add(seatNumber);
    }

}
