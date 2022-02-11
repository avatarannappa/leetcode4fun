import java.util.Arrays;

/**
 * 1984. 学生分数的最小差值.
 * easy
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/2/11
 */
public class Minimumdifference1984 {

    public int minimumDifference(int[] nums, int k) {
        // 滑动窗口
        int ans = Integer.MAX_VALUE;
        if (k == 1) {
            return 0;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - k + 1; i++) {
            int temp = nums[i + k - 1] - nums[i];
            ans = Math.min(ans, temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {9, 4, 1, 7};
        int k = 2;
        // 2
        System.out.println(new Minimumdifference1984().minimumDifference(nums, k));
    }

}
