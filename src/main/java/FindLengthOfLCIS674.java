/**
 * 674. 最长连续递增序列
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/1/27
 */
public class FindLengthOfLCIS674 {

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 1;
        int temp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                temp++;
            } else {
                temp = 1;
            }

            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 3, 7};
        System.out.println(new FindLengthOfLCIS674().findLengthOfLCIS(nums));
    }
}
