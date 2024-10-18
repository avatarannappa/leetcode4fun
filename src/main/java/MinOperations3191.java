/**
 * 3191. 使二进制数组全部等于 1 的最少操作次数 I.
 * medium
 *
 * @author avatarannappa
 * @version 2024/10/18
 */
public class MinOperations3191 {

    public int minOperations(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0) {
                nums[i] = 1;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                cnt++;
            }
        }
        if (nums[nums.length - 2] == 0 || nums[nums.length - 1] == 0) {
            return -1;
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 1, 0, 0};
        // 3
        System.out.println(new MinOperations3191().minOperations(nums));
    }
}
