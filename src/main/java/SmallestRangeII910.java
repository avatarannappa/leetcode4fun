import java.util.Arrays;

/**
 * 910. 最小差值II.
 * medium
 *
 * @author avatarannappa
 * @version 2024/10/21
 */
public class SmallestRangeII910 {

    public int smallestRangeII(int[] nums, int k) {
        // 规律。 贪心：小的变大，大的变小
        Arrays.sort(nums);
        int mi = nums[0];
        int ma = nums[nums.length - 1];
        int res = ma - mi;
        for (int i = 0; i < nums.length - 1; i++) {
            int a = nums[i];
            int b = nums[i + 1];
            res = Math.min(res, Math.max(ma - k, a + k) - Math.min(mi + k, b - k));
        }
        return res;
    }

    public int smallestRangeIIOld(int[] nums, int k) {
        // 我的思路
        if (nums.length == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[n - 1] - nums[0] <= k) {
            // 1,1,2 | 3
            return nums[n - 1] - nums[0];
        }

        // 1,6,10 | 3
        int start = nums[0] + k;
        int end = nums[n - 1] - k;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int now = nums[i] + k;
            int next = nums[i + 1] - k;
            if (next >= now) {
                // 1,9,10 | 3
                return nums[n - 1] - nums[0] - 2 * k;
            }
            int min = min(start, end, now, next);
            int max = max(start, end, now, next);
            diff = Math.min(diff, max - min);

        }
        return Math.min(diff, nums[n - 1] - nums[0]);
    }

    private int min(int... nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        return min;
    }

    private int max(int... nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {4, 8, 2, 7, 2};
        int k = 5;
        // 6
        System.out.println(new SmallestRangeII910().smallestRangeII(nums, k));
    }

}
