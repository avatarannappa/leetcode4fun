import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积
 *
 * @author avatarannappa
 * @version 1.0, 2020/3/30
 */
public class ProductExceptSelf238 {

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        left[0] = 1;
        int[] right = new int[len];
        right[len - 1] = 1;
        int[] result = new int[len];
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i - 1];
            right[len - 1 - i] = right[len - i] * nums[len - i];
        }
        for (int i = 0; i < len; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(new ProductExceptSelf238().productExceptSelf(nums)));
    }
}
