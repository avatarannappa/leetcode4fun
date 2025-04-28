/**
 * 3392. 统计符合条件长度为3的子数组数目.
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2025/4/28
 */
public class CountSubarrays3392 {

    public int countSubarrays(int[] nums) {
        // 模拟
        int count = 0;

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == (nums[i - 1] + nums[i + 1]) * 2) {
                count++;
            }
        }

        return count;
    }
}
