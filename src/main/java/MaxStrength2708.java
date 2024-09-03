import java.util.Arrays;

/**
 * 2708. 一个小组的最大实力值.
 * medium
 *
 * @author avatarannappa
 * @version 2024/9/3
 */
public class MaxStrength2708 {

    public long maxStrength(int[] nums) {
        // 分类讨论
        // TODO 动态规划
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        if (nums.length == 2 && nums[0] < 0 && nums[1] >= 0) {
            return nums[1];
        }
        long res = 1;
        boolean sign = false;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res *= nums[i];
                sign = true;
            } else if (nums[i] < 0) {
                if (i % 2 == 1) {
                    res = res * nums[i] * nums[i - 1];
                    sign = true;
                }
            } else {
                if (!sign && i == nums.length - 1) {
                    res = 0;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, -1, -5, 2, 5, -9};
        System.out.println(new MaxStrength2708().maxStrength(nums));
    }
}