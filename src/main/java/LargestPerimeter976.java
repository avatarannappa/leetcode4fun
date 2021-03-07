import java.util.Arrays;

/**
 * 976. 三角形的最大周长
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/3/8
 */
public class LargestPerimeter976 {

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                result = nums[i] + nums[i - 1] + nums[i - 2];
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        System.out.println(new LargestPerimeter976().largestPerimeter(nums));
    }
}
