/**
 * 2656. K 个元素的最大和
 * easy
 *
 * @author avatarannappa
 * @date 2023/11/15
 */
public class MaximizeSum2656 {

    public int maximizeSum(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max * k + (k - 1) * k / 2;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 3;
        // 18
        System.out.println(new MaximizeSum2656().maximizeSum(nums, k));
    }
}
