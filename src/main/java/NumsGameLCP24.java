import java.util.PriorityQueue;

/**
 * LCP 24. 数字游戏
 * hard
 *
 * @author avatarannappa
 * @date 2024/2/1
 */
public class NumsGameLCP24 {

    public int[] numsGame(int[] nums) {
        // 坐标系转换成到横线的距离问题（画图） + 中位数贪心 + 中位数记录（对顶堆）+ 距离算法（a1 - mid + a2 - mid + a3 - mid + mid - b1 + mid - b2） = sumA - sumB
        final int MOD = 1_000_000_007;
        int[] ans = new int[nums.length];
        // 维护较小的一半，大根堆
        PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
        // 维护较大的一半，小根堆
        PriorityQueue<Integer> right = new PriorityQueue<>();
        long leftSum = 0, rightSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int b = nums[i] - i;
            if (i % 2 == 0) {
                // 前缀长度是奇数
                if (!left.isEmpty() && b < left.peek()) {
                    leftSum -= left.peek() - b;
                    left.offer(b);
                    b = left.poll();
                }
                rightSum += b;
                right.offer(b);
                ans[i] = (int) ((rightSum - right.peek() - leftSum) % MOD);
            } else {
                // 前缀长度是偶数
                if (b > right.peek()) {
                    rightSum += b - right.peek();
                    right.offer(b);
                    b = right.poll();
                }
                leftSum += b;
                left.offer(b);
                ans[i] = (int) ((rightSum - leftSum) % MOD);
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 6, 7};
        // 0,0,0,5,6,7
        System.out.println(new NumsGameLCP24().numsGame(nums));
    }

}
