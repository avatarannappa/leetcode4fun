import java.util.Arrays;

/**
 * 1005. K 次取反后最大化的数组和
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/12/16
 */
public class LargestSumAfterKNegations1005 {

    public int largestSumAfterKNegations(int[] nums, int k) {
        int negCount = 0;
        int zeroCount = 0;
        for (int i : nums) {
            if (i < 0) {
                negCount++;
            } else if (i == 0) {
                zeroCount++;
            }
        }
        int ans = 0;
        if (negCount >= k) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (i < k) {
                    ans += -nums[i];
                } else {
                    ans += nums[i];
                }
            }
        } else if (zeroCount > 0) {
            for (int i : nums) {
                ans += Math.abs(i);
            }
        } else {
            if ((k - negCount) % 2 == 0) {
                for (int i : nums) {
                    ans += Math.abs(i);
                }
            } else {
                int min = Integer.MAX_VALUE;
                for (int i : nums) {
                    min = Math.min(min, Math.abs(i));
                    ans += Math.abs(i);
                }
                ans -= min * 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 2, 3 };
        int k = 1;
        // 13
        System.out.println(new LargestSumAfterKNegations1005().largestSumAfterKNegations(nums, k));
    }
}
