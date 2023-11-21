/**
 * 2216. 美化数组的最小删除数
 * medium
 *
 * @author avatarannappa
 * @date 2023/11/21
 */
public class MinDeletion2216 {

    public int minDeletion(int[] nums) {
        // 贪心
        boolean odd = false;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (odd) {
                odd = !odd;
            } else {
                if (i == 0 || nums[i] == nums[i - 1]) {
                    continue;
                } else {
                    sum += 2;
                    odd = !odd;
                }
            }
        }
        return nums.length - sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3};
        // 2
        System.out.println(new MinDeletion2216().minDeletion(nums));
    }
}
