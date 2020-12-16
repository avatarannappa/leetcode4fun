/**
 * 665. 非递减数列
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2020/12/16
 */
public class CheckPossibility665 {

    public boolean checkPossibility(int[] nums) {
        boolean one = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (!one) {
                    return false;
                } else {
                    one = false;
                    if (i > 1) {
                        if (nums[i] < nums[i - 2]) {
                            nums[i] = nums[i - 1];
                        } else {
                            nums[i - 1] = nums[i];
                        }
                    } else {
                        nums[i - 1] = nums[i];
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // 3,4,2,3
        // -1,4,2,3
        // 5,7,1,8
        int[] nums = {3, 4, 2, 3};
        System.out.println(new CheckPossibility665().checkPossibility(nums));
    }
}
