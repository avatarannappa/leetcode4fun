/**
 * 330. 按要求补齐数组. hard
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2021/9/28
 */
public class MinPatches330 {

    public int minPatches(int[] nums, int n) {
        // 偏数学
        int cur = 0;
        int count = 0;
        long num = 1;
        while (num <= n) {
            if (cur >= nums.length || num < nums[cur]) {
                num = num * 2;
                count++;
            } else {
                num += nums[cur];
                cur++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 31, 33 };

        int n = 2147483647;
        System.out.println(new MinPatches330().minPatches(nums, n));
    }

}
