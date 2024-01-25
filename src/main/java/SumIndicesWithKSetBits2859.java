import java.util.Arrays;
import java.util.List;

/**
 * 2859. 计算 K 置位下标对应元素的和
 * easy
 *
 * @author avatarannappa
 * @date 2024/1/25
 */
public class SumIndicesWithKSetBits2859 {

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (bitCount(i) == k) {
                sum += nums.get(i);
            }
        }
        return sum;
    }

    public int bitCount(int x) {
        int res = 0;
        while (x > 0) {
            res += x & 1;
            x = x >> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(5, 10, 1, 5, 2);
        int k = 1;
        // 13
        System.out.println(new SumIndicesWithKSetBits2859().sumIndicesWithKSetBits(nums, k));
    }
}
