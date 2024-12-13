import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 3264. K 次乘运算后的最终数组 I.
 * easy
 *
 * @author avatarannappa
 * @version 2024/12/13
 */
public class GetFinalState3264 {

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        // 优先队列
        int n = nums.length;
        int[] res = new int[n];
        System.arraycopy(nums, 0, res, 0, n);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0] == 0 ? o1[1] - o2[1] : o1[0] - o2[0]);
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        while (k > 0) {
            int[] min = pq.poll();
            pq.offer(new int[]{min[0] * multiplier, min[1]});
            k--;
        }
        pq.forEach(x -> res[x[1]] = x[0]);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 5, 6};
        int k = 5;
        int multiplier = 2;
        // 输出：[8,4,6,5,6]
        System.out.println(Arrays.toString(new GetFinalState3264().getFinalState(nums, k, multiplier)));
    }

}
