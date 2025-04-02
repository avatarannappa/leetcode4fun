/**
 * 2874. 有序三元组中的最大值 II.
 * medium
 *
 * @author avatarannappa
 * @version 2025/4/2
 * @see MaximumTripletValue2873
 */
public class MaximumTripletValue2874 {

    public long maximumTripletValue(int[] nums) {
        // 贪心 + 前后缀数组
        int n = nums.length;
        int[] suffix = new int[n];
        int[] prefix = new int[n];
        long max = 0;
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = Math.max(nums[i], suffix[Math.min(n - 1, i + 1)]);
        }

        for (int i = 0; i < n; i++) {
            prefix[i] = Math.max(nums[i], prefix[Math.max(0, i - 1)]);
            if (i > 0 && i < n - 1) {
                max = Math.max(max, (long) (prefix[i - 1] - nums[i]) * suffix[i + 1]);
            }
        }
        return max;
    }
}
