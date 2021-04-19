/**
 * 剑指 Offer 03. 数组中重复的数字
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/4/19
 */
public class FindRepeatNumberOffer3 {

    public int findRepeatNumber(int[] nums) {
        int[] mask = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (mask[nums[i]] != 0) {
                return nums[i];
            }
            mask[nums[i]] = 1;
        }
        return -1;
    }
}
