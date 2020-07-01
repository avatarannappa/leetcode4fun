/**
 * 154. 寻找旋转排序数组中的最小值 II.
 *
 * @author avatarannappa
 * @version 1.0, 2020/7/2
 */
public class FindMin154 {

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
        int[] nums = {2, 2, 2, 0, 1};
        System.out.println(new Findmin153().findMin(nums));
    }

}
