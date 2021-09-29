/**
 * 413. 等差数列划分. medium
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2021/9/29
 */
public class NumberOfArithmeticSlices413 {

    public int numberOfArithmeticSlices(int[] nums) {
        // 先分段，然后用数学方法计算
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int result = 0;

        int pp = 0;
        int p = 1;
        int len = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[p] == nums[p] - nums[pp]) {
                len++;
            } else {
                if (len > 0) {
                    result += len * (len + 1) / 2;
                }
                len = 0;
            }
            pp = p;
            p = i;
        }
        result += len * (len + 1) / 2;
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        // 6
        System.out.println(new NumberOfArithmeticSlices413().numberOfArithmeticSlices(nums));
    }
}
