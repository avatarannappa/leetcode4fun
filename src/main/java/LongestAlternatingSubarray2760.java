/**
 * 2760. 最长奇偶子数组
 * easy
 *
 * @author avatarannappa
 * @date 2023/11/16
 */
public class LongestAlternatingSubarray2760 {

    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0 || nums[i] > threshold) {
                continue;
            }
            int j = i + 1;
            while (j < nums.length && nums[j] % 2 != nums[j - 1] % 2 && nums[j] <= threshold) {
                j++;
            }
            ans = Math.max(ans, j - i);
            i = j - 1;
        }

        return ans;
    }
}
