import java.util.Arrays;

/**
 * 2560. 打家劫舍 IV
 * medium
 *
 * @author avatarannappa
 * @date 2023/9/19
 */
public class MinCapability2560 {

    public int minCapability(int[] nums, int k) {
        // 最小化最大值，二分/贪心
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        while (min <= max) {
            int mid = (min + max) / 2;
            int count = 0;
            boolean canVisit = true;
            for (int num : nums) {
                if (num <= mid && canVisit) {
                    count++;
                    canVisit = false;
                } else {
                    canVisit = true;
                }
            }
            if (count >= k) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
}
