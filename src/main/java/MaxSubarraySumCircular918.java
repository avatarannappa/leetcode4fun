import java.util.Arrays;

/**
 * 918. 环形子数组的最大和. hard
 *
 * @author avatarannappa
 * @version 1.0, 2021/10/12
 */
public class MaxSubarraySumCircular918 {

    public int maxSubarraySumCircular(int[] nums) {
        // DP O(n) 最大区间和sum-最小区间问题
        int sum = Arrays.stream(nums).sum();
        // 因为只计算前一个数，其实不用dp数组，用一个变量就行了。不想改了
        int[] dpMax = new int[nums.length];
        dpMax[0] = nums[0];
        int max = nums[0];

        int[] dpMin = new int[nums.length];
        dpMin[0] = nums[0];
        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dpMax[i] = dpMax[i - 1] > 0 ? nums[i] + dpMax[i - 1] : nums[i];
            max = Math.max(max, dpMax[i]);

            dpMin[i] = dpMin[i - 1] < 0 ? nums[i] + dpMin[i - 1] : nums[i];
            min = Math.min(min, dpMin[i]);
        }
        if (sum == min) {
            return max;
        }
        return Math.max(max, sum - min);
    }

    public int maxSubarraySumCircularOld(int[] nums) {
        // 一层DP O(n**2) 101/110用例超时
        // 参考53. 最大子序和
        int result = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int[] dp = new int[nums.length];
            dp[i] = nums[i];
            for (int j = i + 1; j < nums.length + i; j++) {
                int pre = (j + nums.length - 1) % nums.length;
                int now = j % nums.length;
                dp[now] = dp[pre] > 0 ? nums[now] + dp[pre] : nums[now];
                result = Math.max(result, dp[now]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // int[] nums = { 5, -3, 5 };
        // 10
        // int[] nums = { -5, 3, 5 };
        // 8
        int[] nums = { -2, -3, -1 };
        // 18
        System.out.println(new MaxSubarraySumCircular918().maxSubarraySumCircular(nums));
    }
}
