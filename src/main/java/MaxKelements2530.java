import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 2530. 执行 K 次操作后的最大分数
 * medium
 *
 * @author avatarannappa
 * @date 2023/10/18
 */
public class MaxKelements2530 {

    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            queue.add(num);
        }

        long ans = 0;

        for (int i = 0; i < k; i++) {
            int max = queue.poll();
            ans += max;
            queue.add((int) Math.ceil(max / 3.0));
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 10, 3, 3, 3};
        int k = 3;
        // 17
        System.out.println(new MaxKelements2530().maxKelements(nums, k));
    }

}
