import java.util.Arrays;

/**
 * 3194. 最小元素和最大元素的最小平均值.
 * easy
 *
 * @author avatarannappa
 * @version 2024/10/16
 */
public class MinimumAverage3194 {

    public double minimumAverage(int[] nums) {
        // 模拟
        Arrays.sort(nums);
        double min = nums[nums.length - 1];
        for (int i = 0, j = nums.length - 1; i < nums.length / 2; i++, j--) {
            min = Math.min(min, (nums[i] + nums[j]) / 2.0);
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = {7, 8, 3, 4, 15, 13, 4, 1};
        // 5.5
        System.out.println(new MinimumAverage3194().minimumAverage(nums));
    }
}
