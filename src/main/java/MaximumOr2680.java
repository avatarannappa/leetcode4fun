/**
 * 2680. 最大或值.
 * medium
 *
 * @author avatarannappa
 * @version 2025/3/21
 */
public class MaximumOr2680 {

    public long maximumOr(int[] nums, int k) {
        // 贪心 + 前缀和 + 后缀和
        int n = nums.length;
        int[] orPreSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            orPreSum[i + 1] = orPreSum[i] | nums[i];
        }
        int[] orPostSum = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            orPostSum[i] = orPostSum[i + 1] | nums[i];
        }

        long max = 0;

        for (int i = 0; i < n; i++) {
            long num = (long) nums[i];
            long otherOrSum = (long) orPreSum[i] | orPostSum[i + 1];
            max = Math.max(max, num << k | otherOrSum);
        }

        return max;
    }
}
