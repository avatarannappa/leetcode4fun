/**
 * 1822. 数组元素积的符号
 * easy
 *
 * @author avatarannappa
 * @date 2022/10/27
 */
public class ArraySign1822 {

    public int arraySign(int[] nums) {
        int ans = 1;

        for (int num : nums) {
            if (num == 0) {
                return 0;
            } else if (num < 0) {
                ans = -ans;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 1, -1, 1, -1};
        // -1
        System.out.println(new ArraySign1822().arraySign(nums));
    }
}
