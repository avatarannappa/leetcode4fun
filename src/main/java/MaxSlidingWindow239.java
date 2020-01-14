/**
 * 239. 滑动窗口最大值
 *
 * @author avatarannappa
 * @version 1.0, 2019/12/15
 */
public class MaxSlidingWindow239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int length = nums.length - k + 1;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int temp = nums[i];
            for (int j = 1; j < k; j++) {
                temp = Math.max(temp, nums[i + j]);
            }
            result[i] = temp;
        }
        return result;
    }
}
