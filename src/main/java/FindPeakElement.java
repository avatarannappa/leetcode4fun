/**
 * 162 寻找峰值.
 * 峰值元素是指其值大于左右相邻值的元素。
 * <p>
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 * <p>
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 * <p>
 * 你可以假设 nums[-1] = nums[n] = -∞。
 *
 * @author avatarannappa
 * @version 1.0, 2019/6/10
 */
public class FindPeakElement {
    public static int findPeakElement(int[] nums) {
        int result = 0;
        int before = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < before) {
                result = i - 1;
                break;
            }
            before = nums[i];
            result = i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        int result = findPeakElement(nums);
        System.out.println(result);
    }
}
