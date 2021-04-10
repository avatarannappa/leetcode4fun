import java.util.Arrays;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/4/10
 */
public class SingleNumbersOffer56I {

    public int[] singleNumbers(int[] nums) {
        int[] result = new int[2];
        int a = nums[0];
        for (int i = 1; i < nums.length; i++) {
            a ^= nums[i];
        }
        String aBinaryString = Integer.toBinaryString(a);
        int mask = 1;
        int num = aBinaryString.length() - aBinaryString.lastIndexOf('1') - 1;
        mask = mask << num;
        int value0 = 0;
        int value1 = 0;
        for (int i : nums) {
            if ((i & mask) == 0) {
                value0 ^= i;
            } else {
                value1 ^= i;
            }
        }
        result[0] = value0;
        result[1] = value1;
        return result;
    }

    public static void main(String[] args) {
        // 要求：时间复杂度O(n) 空间复杂度O(1)
        int[] nums = {1, 2, 10, 4, 1, 4, 3, 3};
        System.out.println(Arrays.toString(new SingleNumbersOffer56I().singleNumbers(nums)));
    }
}
