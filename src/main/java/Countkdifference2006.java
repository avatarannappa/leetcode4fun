/**
 * 2006. 差的绝对值为 K 的数对数目.
 * easy
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/2/9
 */
public class Countkdifference2006 {

    public int countKDifference(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 4};
        int k = 2;
        System.out.println(new Countkdifference2006().countKDifference(nums, k));
    }

}
