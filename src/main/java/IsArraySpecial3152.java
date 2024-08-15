import java.util.Arrays;

/**
 * 3152. 特殊数组 II
 * medium
 *
 * @author avatarannappa
 * @date 2024/8/15
 */
public class IsArraySpecial3152 {

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        // 前缀和 | DP
        int[] pre = new int[nums.length];
        pre[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 != nums[i - 1] % 2) {
                pre[i] = pre[i - 1] + 1;
            } else {
                pre[i] = 1;
            }
        }

        boolean[] res = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            res[i] = query[1] - query[0] < pre[query[1]];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 1, 6};
        int[][] queries = {{0, 2}, {2, 3}};
        // 输出：[false,true]
        System.out.println(Arrays.toString(new IsArraySpecial3152().isArraySpecial(nums, queries)));
    }

}
