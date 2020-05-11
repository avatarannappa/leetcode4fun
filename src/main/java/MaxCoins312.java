/**
 * 312. 戳气球.
 *
 * @author avatarannappa
 * @version 1.0, 2020/5/11
 */
public class MaxCoins312 {

    public int maxCoins(int[] nums) {
        int len = nums.length + 2;
        int[] newNums = new int[len];
        for (int i = 0; i < nums.length; i++) {
            newNums[i + 1] = nums[i];
        }
        newNums[0] = newNums[len - 1] = 1;
        int[][] dp = new int[len][len];
        return recursion(dp, newNums, 0, len - 1);
    }

    public int recursion(int[][] dp, int[] nums, int left, int right) {
        if (right - left < 2) {
            return 0;
        }
        if (dp[left][right] > 0) {
            return dp[left][right];
        }
        int max = 0;
        for (int i = left + 1; i < right; i++) {
            max = Math.max(max, recursion(dp, nums, left, i) + recursion(dp, nums, i, right) +
                                nums[left] * nums[i] * nums[right]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        System.out.println(new MaxCoins312().maxCoins(nums));
    }
}
