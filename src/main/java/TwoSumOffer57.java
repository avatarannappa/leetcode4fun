import java.util.Arrays;

/**
 * 剑指 Offer 57. 和为s的两个数字
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/4/9
 */
public class TwoSumOffer57 {

    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                return new int[] {nums[i], nums[j]};
            }
        }

        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {10, 26, 30, 31, 47, 60};
        int target = 40;
        System.out.println(Arrays.toString(new TwoSumOffer57().twoSum(nums, target)));
    }
}
