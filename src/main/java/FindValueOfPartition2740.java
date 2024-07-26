import java.util.Arrays;

/**
 * 2740. 找出分区值
 * medium
 *
 * @author avatarannappa
 * @date 2024/7/26
 */
public class FindValueOfPartition2740 {

    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            res = Math.min(res, nums[i] - nums[i - 1]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4};
        // 输出：1
        System.out.println(new FindValueOfPartition2740().findValueOfPartition(nums));
    }
}
