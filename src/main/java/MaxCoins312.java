/**
 * 312. 戳气球.
 *
 * @author avatarannappa
 * @version 1.0, 2020/5/11
 */
public class MaxCoins312 {

    public int maxCoins(int[] nums) {
        int dp[][] = new int[nums.length][nums.length];
        if (nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i; j++) {
                fill(dp, nums, j, j + i);
            }
        }
        return dp[0][nums.length - 1];
    }

    void fill(int[][] dp, int nums[], int start, int end) {
        int max = 0;
        for (int i = start; i <= end; i++) {
            max = Math.max(max, (start - 1 < 0 ? 1 : nums[start - 1]) * nums[i] * (end + 1 > nums.length - 1 ? 1 : nums[end + 1]) + (start > i - 1 ? 0 : dp[start][i - 1]) + (end < i + 1 ? 0 : dp[i + 1][end]));
        }
        dp[start][end] = max;
    }

    public int maxCoinsOld(int[] nums) {
        // 超时
        int len = nums.length + 2;
        int[] newNums = new int[len];
        for (int i = 0; i < nums.length; i++) {
            newNums[i + 1] = nums[i];
        }
        newNums[0] = newNums[len - 1] = 1;
        int[][] dp = new int[len][len];
        return recursionOld(dp, newNums, 0, len - 1);
    }

    public int recursionOld(int[][] dp, int[] nums, int left, int right) {
        if (right - left < 2) {
            return 0;
        }
        if (dp[left][right] > 0) {
            return dp[left][right];
        }
        int max = 0;
        for (int i = left + 1; i < right; i++) {
            max = Math.max(max, recursionOld(dp, nums, left, i) + recursionOld(dp, nums, i, right) +
                                nums[left] * nums[i] * nums[right]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {8, 2, 6, 8, 9, 8, 1, 4, 1, 5, 3, 0, 7, 7, 0, 4, 2, 2, 5};
        System.out.println(new MaxCoins312().maxCoins(nums));
    }
}
