import java.util.Arrays;

/**
 * 3162. 优质数对的总数 I.
 * easy
 *
 * @author avatarannappa
 * @version 2024/10/10
 */
public class NumberOfPairs3162 {

    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        // 模拟，时间复杂度略高
        int res = 0;
        nums2 = Arrays.stream(nums2).map(i -> i * k).toArray();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                if (num1 % num2 == 0) {
                    res++;
                }
            }
        }
        return res;
    }
}
