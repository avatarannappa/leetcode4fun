import java.util.Arrays;

/**
 * 164. 最大间距.
 *
 * @author avatarannappa
 * @version 1.0, 2020/7/4
 */
public class MaximumGap164 {

    public int maximumGap(int[] nums) {
        // 比较排序 & 非比较排序
        int result = 0;
        if (nums == null || nums.length < 2) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            int gap = nums[i] - nums[i - 1];
            if (gap > result) {
                result = gap;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 9, 1};
        System.out.println(new MaximumGap164().maximumGap(nums));
    }
}
