import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1696. 跳跃游戏 VI
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2024/2/5
 */
public class MaxResult1696 {

    public int maxResult(int[] nums, int k) {
        // DP+双端队列，单调队列 O(n)
        // @see 滑动窗口最大值
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offerLast(0);
        for (int i = 1; i < n; i++) {
            while (queue.peekFirst() < i - k) {
                queue.pollFirst();
            }
            dp[i] = dp[queue.peekFirst()] + nums[i];
            while (!queue.isEmpty() && dp[queue.peekLast()] <= dp[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        return dp[n - 1];
    }

    public int maxResultOld(int[] nums, int k) {
        // DP+优先队列，超时 O(nlogn)
        int n = nums.length;
        int[] dp = new int[n];
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            dp[i] = queue.isEmpty() ? nums[i] : queue.peek() + nums[i];
            if (i - k >= 0) {
                queue.remove(dp[i - k]);
            }
            queue.add(dp[i]);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = { 1, -1, -2, 4, -7, 3 };
        int k = 2;
        // 7
        System.out.println(new MaxResult1696().maxResult(nums, k));
    }
}
