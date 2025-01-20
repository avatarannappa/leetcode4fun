/**
 * 2239. 找到最接近 0 的数字.
 * easy
 *
 * @author avatarannappa
 * @version 2025/1/20
 */
public class FindClosestNumber2239 {

    public int findClosestNumber(int[] nums) {
        // 模拟
        int min = Integer.MAX_VALUE;
        int res = nums[0];
        for (int num : nums) {
            int abs = Math.abs(num);
            if (abs < min) {
                min = abs;
                res = num;
            } else if (abs == min) {
                res = Math.max(res, num);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, -1, 1};
        System.out.println(new FindClosestNumber2239().findClosestNumber(nums));
    }

}
