/**
 * 376. 摆动序列,Wiggle Subsequence. medium
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2021/10/09
 */
public class WiggleMaxLength376 {

    public int wiggleMaxLength(int[] nums) {
        // 先倒叙递归的想，发现正序递推也正确
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        }
        int result = 1;

        int sign = 0;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (pre - nums[i] > 0 && sign <= 0) {
                sign = 1;
                result++;
            } else if (pre - nums[i] < 0 && sign >= 0) {
                sign = -1;
                result++;
            }
            pre = nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        // int[] nums = { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 };
        // 7
        int[] nums = { 33, 53, 12, 64, 50, 41, 45, 21, 97, 35, 47, 92, 39, 0, 93, 55, 40, 46, 69, 42, 6, 95, 51, 68, 72,
                9, 32, 84, 34, 64, 6, 2, 26, 98, 3, 43, 30, 60, 3, 68, 82, 9, 97, 19, 27, 98, 99, 4, 30, 96, 37, 9, 78,
                43, 64, 4, 65, 30, 84, 90, 87, 64, 18, 50, 60, 1, 40, 32, 48, 50, 76, 100, 57, 29, 63, 53, 46, 57, 93,
                98, 42, 80, 82, 9, 41, 55, 69, 84, 82, 79, 30, 79, 18, 97, 67, 23, 52, 38, 74, 15 };
        // 67
        System.out.println(new WiggleMaxLength376().wiggleMaxLength(nums));
    }
}
