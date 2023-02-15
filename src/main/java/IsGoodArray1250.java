/**
 * 1250. 检查「好数组」
 * hard
 *
 * @author avatarannappa
 * @date 2023/2/15
 */
public class IsGoodArray1250 {

    public boolean isGoodArray(int[] nums) {
        // 数论，裴蜀定理
        int a = nums[0];
        for (int num : nums) {
            a = gcd(a, num);
            if (a == 1) {
                return true;
            }
        }
        return false;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        int[] nums = {12, 5, 7, 23};
        System.out.println(new IsGoodArray1250().isGoodArray(nums));
    }
}
