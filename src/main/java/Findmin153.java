/**
 * 153. 寻找旋转排序数组中的最小值.
 *
 * @author avatarannappa
 * @version 1.0, 2020/7/1
 */
public class Findmin153 {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int result = nums[0];
        for (int num : nums) {
            if (num < result) {
                result = num;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(new Findmin153().findMin(nums));
    }
}
