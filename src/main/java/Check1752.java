/**
 * 1752. 检查数组是否经排序和轮转得到
 * easy.
 *
 * @author avatarannappa
 * @version 1.0, 2022/11/27
 */
public class Check1752 {

    public boolean check(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (count > 0 && nums[i] > nums[0]) {
                return false;
            }
            if (nums[i] < nums[i - 1]) {
                count++;
                if (count == 2) {
                    return false;
                }
                if (nums[i] > nums[0]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        // false
        System.out.println(new Check1752().check(nums));
    }
}
