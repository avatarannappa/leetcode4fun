/**
 * 2873. 有序三元组中的最大值 I.
 * easy
 *
 * @author avatarannappa
 * @version 2025/4/2
 */
public class MaximumTripletValue2873 {

    public long maximumTripletValue(int[] nums) {
        // 模拟
        long max = 0;

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    max = Math.max(max, (long) (nums[i] - nums[j]) * nums[k]);
                }
            }
        }

        return max;
    }
}
