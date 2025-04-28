/**
 * 2302. 统计得分小于K的子数组数目.
 * hard
 *
 * @author avatarannappa
 * @version 1.0, 2025/4/28
 */
public class CountSubarrays2302 {

    public long countSubarrays(int[] nums, long k) {
        // 规律 + 双指针
        int n = nums.length;
        int l = 0;
        int r = 0;
        long res = 0;
        long sum = 0;
        for (; r < n; r++) {
            sum += nums[r];
            while (l <= r && sum * (r - l + 1) >= k) {
                sum -= nums[l++];
            }
            res += r - l + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 3, 5};
        long k = 10;
        System.out.println(new CountSubarrays2302().countSubarrays(nums, k));
    }
}
