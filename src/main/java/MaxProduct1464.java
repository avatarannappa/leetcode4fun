/**
 * 1464. 数组中两元素的最大乘积.
 *
 * @author avatarannappa
 * @version 1.0, 2020/10/11
 */
public class MaxProduct1464 {

    public int maxProduct(int[] nums) {
        int a = Math.max(nums[0], nums[1]);
        int b = Math.min(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int num = nums[i];
            if (num >= a) {
                b = a;
                a = num;
            } else if (num > b) {
                b = num;
            }
        }
        return (a - 1) * (b - 1);
    }

    public int maxProductNew(int[] nums) {
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if (num > a) {
                b = a;
                a = num;
            } else if (num > b) {
                b = num;
            }
        }
        return (a - 1) * (b - 1);
    }

}
