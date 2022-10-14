import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 480. 滑动窗口中位数
 * hard
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/10/14
 */
public class MedianSlidingWindow480 {

    public double[] medianSlidingWindow(int[] nums, int k) {
        // 滑动窗口小顶堆/大顶堆 O(nlog(k))
        int n = nums.length;
        double[] ans = new double[n - k + 1];
        if (k == 1) {
            for (int i = 0; i < nums.length; i++) {
                ans[i] = nums[i];
            }
            return ans;
        }
        // 大顶堆，小顶堆
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();

        int size = k / 2;
        for (int i = 0; i < k; i++) {
            int num = nums[i];
            if (maxQueue.size() < size) {
                maxQueue.add(num);
            } else {
                maxQueue.add(num);
                minQueue.add(maxQueue.poll());
            }
        }

        if (k % 2 == 0) {
            ans[0] = ((double) minQueue.peek() + (double) maxQueue.peek()) / 2;
        } else {
            ans[0] = minQueue.peek();
        }
        for (int i = k, cur = 1; i < nums.length; i++, cur++) {
            int num = nums[i];
            int removeNum = nums[i - k];
            if (removeNum <= maxQueue.peek()) {
                maxQueue.remove(removeNum);
                maxQueue.add(minQueue.poll());
                maxQueue.add(num);
                minQueue.add(maxQueue.poll());
            } else {
                minQueue.remove(removeNum);
                maxQueue.add(num);
                minQueue.add(maxQueue.poll());
            }

            if (k % 2 == 0) {
                ans[cur] = ((double) minQueue.peek() + (double) maxQueue.peek()) / 2;
            } else {
                ans[cur] = minQueue.peek();
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        int k = 1;
        System.out.println(Arrays.toString(new MedianSlidingWindow480().medianSlidingWindow(nums, k)));
    }
}
