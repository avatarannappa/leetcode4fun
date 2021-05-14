import java.util.Arrays;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * hard
 *
 * @author avatarannappa
 * @version 1.0, 2021/5/14
 */
public class MaxSlidingWindowOffer59 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 1) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        Arrays.fill(result, Integer.MIN_VALUE);
        for (int i = 0; i < k; i++) {
            result[0] = Math.max(nums[i], result[0]);
        }

        for (int i = 1; i < result.length; i++) {
            if (nums[i - 1] == result[i - 1]) {
                for (int j = 0; j < k; j++) {
                    result[i] = Math.max(nums[i + j], result[i]);
                }
            } else {
                result[i] = Math.max(result[i - 1], nums[i + k - 1]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {7, 2, 4};
        int k = 2;
        System.out.println(Arrays.toString(new MaxSlidingWindowOffer59().maxSlidingWindow(nums, k)));
    }
}
