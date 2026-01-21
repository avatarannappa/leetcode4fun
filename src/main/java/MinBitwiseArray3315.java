import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3315. 构造最小位运算数组 II
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2026/1/21
 */
public class MinBitwiseArray3315 {

    public int[] minBitwiseArray(List<Integer> nums) {
        int[] res = new int[nums.size()];
        Arrays.fill(res, -1);

        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            String str = Integer.toBinaryString(num);
            if ((num & 1) == 0) {
                continue;
            }
            if ((num & (num + 1)) == 0) {
                res[i] = num >> 1;
                continue;
            }
            int lastZero = str.lastIndexOf('0');
            str = str.substring(0, lastZero + 1) + '0' + str.substring(lastZero + 2);
            res[i] = Integer.parseInt(str, 2);
        }

        return res;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(2, 3, 5, 7, 11);
        // -1 1 4 3 9
        System.out.println(Arrays.toString(new MinBitwiseArray3315().minBitwiseArray(nums)));
    }
}
