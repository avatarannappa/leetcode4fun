/**
 * 485. 最大连续1的个数.
 *
 * @author avatarannappa
 * @version 1.0, 2020/7/11
 */
public class FindMaxConsecutiveOnes485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        if (nums == null || nums.length == 0) {
            return max;
        }
        int temp = 0;
        for (int num : nums) {
            if (num == 0) {
                temp = 0;
            } else {
                temp++;
                if (temp > max) {
                    max = temp;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(new FindMaxConsecutiveOnes485().findMaxConsecutiveOnes(nums));
    }
}
