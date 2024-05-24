import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1673. 找出最具竞争力的子序列
 * medium
 *
 * @author avatarannappa
 * @date 2024/5/24
 */
public class MostCompetitive1673 {

    public int[] mostCompetitive(int[] nums, int k) {
        // 单调栈
        int[] res = new int[k];

        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && n - i + deque.size() > k && deque.peek() > nums[i]) {
                deque.pop();
            }
            deque.push(nums[i]);
        }
        while (deque.size() > k) {
            deque.pop();
        }
        for (int i = k - 1; i >= 0; i--) {
            res[i] = deque.pop();
        }

        return res;
    }

    public int[] mostCompetitiveOld(int[] nums, int k) {
        // 滑动窗口.超出时间限制
        int n = nums.length;
        // 边界
        if (n == k) {
            return nums;
        }

        // 初始化
        Map<Integer, int[]> map = new HashMap<>();
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0] == 0 ? o1[1] - o2[1] : o1[0] - o2[0]);
        for (int i = 0; i < n - k + 1; i++) {
            int[] tuple = new int[2];
            tuple[0] = nums[i];
            tuple[1] = i;
            map.put(i, tuple);
            queue.add(tuple);
        }

        // 滑动
        int[] res = new int[k];
        int l = 0;
        for (int i = 0, r = n - k + 1; i < k; i++, r++) {
            int[] tuple = queue.poll();
            res[i] = tuple[0];
            for (; l < tuple[1]; l++) {
                queue.remove(map.get(l));
            }
            if (r >= n) {
                break;
            }
            int[] next = new int[2];
            next[0] = nums[r];
            next[1] = r;
            map.put(r, next);
            queue.add(next);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 3, 5, 4, 9, 6};
        int k = 4;
        // 2,3,3,4
        System.out.println(Arrays.toString(new MostCompetitive1673().mostCompetitive(nums, k)));
    }

}
