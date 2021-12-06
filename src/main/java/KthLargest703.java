import java.util.PriorityQueue;

/**
 * 703. 数据流中的第 K 大元素.
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/12/6
 */
public class KthLargest703 {
    
    PriorityQueue<Integer> queue;
    int k;
    public KthLargest703(int k, int[] nums) {
        queue = new PriorityQueue<>();
        this.k = k;
        for (int i : nums) {
            queue.add(i);
            if (queue.size() > k) {
                queue.poll();
            }
        }
    }
    
    public int add(int val) {
        queue.add(val);
        if (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{};
        KthLargest703 k = new KthLargest703(1, nums);
        System.out.println(k.add(1));
    }

}
