import java.util.Arrays;

/**
 * 628. 三个数的最大乘积
 *
 * @author avatarannappa
 * @version 1.0, 2020/8/7
 */
public class MaximumProduct628 {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int mid = len / 2;
        int max = Math.max(nums[len - 1] * nums[len - 2] * nums[len - 3], nums[0] * nums[1] * nums[2]);
        max = Math.max(nums[mid] * nums[mid - 1] * nums[mid + 1], max);
        max = Math.max(nums[0] * nums[1] * nums[len - 1], max);
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(new MaximumProduct628().maximumProduct(nums));
    }
}
