import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素.
 *
 * @author avatarannappa
 * @version 1.0, 2020/2/20
 */
public class FindKthLargest215 {

    public int findKthLargestHeap(int[] nums, int k) {
        // 堆
        // TODO 自己实现堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            queue.add(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    public int findKthLargest(int[] nums, int k) {
        // 排序
        // TODO 自己实现快排
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        System.out.println(new FindKthLargest215().findKthLargest(nums, k));
    }
}
