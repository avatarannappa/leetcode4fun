import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/4/20
 */
public class SingleNumberOffer56II {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public int singleNumberNew(int[] nums) {
        // https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/solution/mian-shi-ti-56-ii
        // -shu-zu-zhong-shu-zi-chu-xian-d-4/
        // 单个位运算规则：
        // 异或运算：x ^ 0 = x​ ， x ^ 1 = ~x
        // 与运算：x & 0 = 0 ， x & 1 = x
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

    public static void main(String[] args) {
        int[] nums = {9, 1, 7, 9, 7, 9, 7};
        System.out.println(new SingleNumberOffer56II().singleNumber(nums));
    }
}
