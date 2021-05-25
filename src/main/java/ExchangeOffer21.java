import java.util.Arrays;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/5/25
 */
public class ExchangeOffer21 {

    public int[] exchange(int[] nums) {
        int[] result = new int[nums.length];
        int index = 0;
        for (int i : nums) {
            if (i % 2 == 1) {
                result[index] = i;
                index++;
            }
        }
        for (int i : nums) {
            if (i % 2 == 0) {
                result[index] = i;
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(new ExchangeOffer21().exchange(nums)));
    }

}
