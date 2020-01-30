import java.util.Arrays;

/**
 * 283. 移动零
 *
 * @author avatarannappa
 * @version 1.0, 2020/1/30
 */
public class MoveZeroes283 {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int zero = 0;
        int positive = 0;
        int end = nums.length - 1;
        while (zero <= end && positive <= end) {
            if (nums[zero] == 0) {
                if (positive <= zero) {
                    positive = zero + 1;
                }

                while (positive <= end && nums[positive] == 0) {
                    positive++;
                }
                if (positive > end) {
                    break;
                }
                nums[zero] = nums[positive];
                nums[positive] = 0;
            }
            zero++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new MoveZeroes283().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
