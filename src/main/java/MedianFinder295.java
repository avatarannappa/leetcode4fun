import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 295. 数据流的中位数
 * hard
 * 同offer41
 *
 * @author avatarannappa
 * @version 1.0, 2021/6/29
 */
public class MedianFinder295 {

    PriorityQueue<Integer> low = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> high = new PriorityQueue<>();

    public MedianFinder295() {

    }

    public void addNum(int num) {
        if (low.size() == high.size()) {
            high.add(num);
            low.add(high.poll());
        } else {
            low.add(num);
            high.add(low.poll());
        }
    }

    public double findMedian() {
        if (low.size() == high.size()) {
            return (low.peek() + high.peek()) / 2.0;
        } else {
            return low.peek();
        }
    }
}
