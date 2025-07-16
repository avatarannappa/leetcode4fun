import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3201. 找出有效子序列的最大长度 I.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2025/7/16
 */
public class MaximumLength3201 {

    public int maximumLength(int[] nums) {
        // 贪心，一次遍历。4种情况：全奇，全偶，奇偶，偶奇
        int[] arr = new int[4];

        boolean needOdd2 = true;
        boolean needOdd3 = false;
        for (int num : nums) {
            if (num % 2 == 0) {
                arr[1]++;
                if (!needOdd2) {
                    arr[2]++;
                    needOdd2 = !needOdd2;
                }
                if (!needOdd3) {
                    arr[3]++;
                    needOdd3 = !needOdd3;
                }
            } else {
                arr[0]++;
                if (needOdd2) {
                    arr[2]++;
                    needOdd2 = !needOdd2;
                }
                if (needOdd3) {
                    arr[3]++;
                    needOdd3 = !needOdd3;
                }
            }
        }

        return Arrays.stream(arr).max().getAsInt();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1, 2, 1, 2};
        System.out.println(new MaximumLength3201().maximumLength(nums));
    }
}
