import java.util.Arrays;

/**
 * 645. 错误的集合. easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/11/16
 */
public class FindErrorNums645 {
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        int[] mask = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            mask[num] = num ^ mask[num];
            if (mask[num] == 0) {
                ans[0] = num;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (mask[i + 1] == 0 && i + 1 != ans[0]) {
                ans[1] = i + 1;
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2 };
        System.out.println(Arrays.toString(new FindErrorNums645().findErrorNums(nums)));
    }
}
