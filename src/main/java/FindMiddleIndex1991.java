/**
 * 1991. 找到数组的中间位置
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2022/10/19
 */
public class FindMiddleIndex1991 {

    public int findMiddleIndex(int[] nums) {
        // 前缀和
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            nums[i] = sum;
        }
        int left;
        int right;
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                left = 0;
            } else {
                left = nums[i - 1];
            }
            right = nums[len - 1] - nums[i];
            if (left == right) {
                return i;
            }
        }
        return -1;
    }
}
