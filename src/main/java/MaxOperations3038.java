/**
 * 3038. 相同分数的最大操作数目 I
 * easy
 *
 * @author avatarappappa
 * @date 2024/6/7
 */
public class MaxOperations3038 {

    public int maxOperations(int[] nums) {
        // 简单模拟
        int n = nums.length;
        int res = 1;
        int sum = nums[0] + nums[1];
        for (int i = 2; i < n; ) {
            if (i + 1 == n || nums[i] + nums[i + 1] != sum) {
                break;
            }
            res++;
            i += 2;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 1};
        // 3
        System.out.println(new MaxOperations3038().maxOperations(nums));
    }
}
