/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/4/12
 */
public class MissingNumberOffer53II {

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums[0] != 0) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                return nums[i] - 1;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 9};
        System.out.println(new MissingNumberOffer53II().missingNumber(nums));
    }
}
