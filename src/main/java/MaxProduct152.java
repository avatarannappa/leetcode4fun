/**
 * 152. 乘积最大子数组.
 *
 * @author avatarannappa
 * @version 1.0, 2020/5/5
 */
public class MaxProduct152 {

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            max = Math.max(max, a);
            if (i + 1 == nums.length) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                a = a * nums[j];
                max = Math.max(max, a);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, -1};
        System.out.println(new MaxProduct152().maxProduct(nums));
    }
}
