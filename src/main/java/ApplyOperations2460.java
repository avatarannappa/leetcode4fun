import java.util.Arrays;

/**
 * 2460. 对数组执行操作
 * easy
 *
 * @author avatarannappa
 * @date 2023/6/5
 */
public class ApplyOperations2460 {

    public int[] applyOperations(int[] nums) {
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                ans[j] = nums[i];
                j++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 1, 1, 0};
        // 1,4,2,0,0,0
        System.out.println(Arrays.toString(new ApplyOperations2460().applyOperations(nums)));
    }
}
