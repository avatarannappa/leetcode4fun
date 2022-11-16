/**
 * 775. 全局倒置与局部倒置
 * medium
 *
 * @author avatarannappa
 * @date 2022/11/16
 */
public class IsIdealPermutation775 {

    public boolean isIdealPermutation(int[] nums) {
        // 数学，不需要求 全局倒置数量 和 局部倒置 数量，判断如果有2,1,0这种全局倒置数量肯定大于局部倒置数量，直接返回false.
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i] - i) > 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // 输入：nums = [1,0,2]
        // 输出：true
        // 解释：有 1 个全局倒置，和 1 个局部倒置。
        int[] nums = {2, 1, 0};
        System.out.println(new IsIdealPermutation775().isIdealPermutation(nums));
    }
}
