import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 剑指 Offer 59 - II. 队列的最大值
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/6/28
 */
public class MaxQueueOffer59II {

    public MaxQueueOffer59II() {

    }

    PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
    Queue<Integer> q = new LinkedList<>();
    Integer max = null;

    public int max_value() {
        if (max == null) {
            return -1;
        }
        return max;
    }

    public void push_back(int value) {
        q.add(value);
        queue.add(value);
        if (max == null || value > max) {
            max = value;
        }
    }

    public int pop_front() {
        if (q.isEmpty()) {
            return -1;
        }
        int p = q.poll();
        queue.remove(p);

        if (p == max) {
            if (queue.isEmpty()) {
                max = null;
            } else {
                max = queue.peek();
            }
        }
        if (q.isEmpty()) {
            max = null;
        }
        return p;
    }
}
