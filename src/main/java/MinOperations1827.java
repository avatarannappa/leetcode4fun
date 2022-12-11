/**
 * 1827. 最少操作使数组递增.
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2022/12/11
 */
public class MinOperations1827 {

    public int minOperation(int[] nums) {
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                ans += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        System.out.println(new MinOperations1827().minOperation(nums));
    }
}
