import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 368. 最大整除子集.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2025/4/6
 */
public class LargestDivisibleSubset368 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        // 记忆化搜索
        // TODO DP
        Arrays.sort(nums);

        int n = nums.length;
        int[] memo = new int[n];
        int[] from = new int[n];
        Arrays.fill(from, -1);
        int maxF = 0;
        int maxI = 0;

        for (int i = 0; i < n; i++) {
            int f = dfs(i, nums, memo, from);
            if (f > maxF) {
                maxF = f;
                maxI = i;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = maxI; i >= 0; i = from[i]) {
            result.add(nums[i]);
        }
        return result;
    }

    private int dfs(int i, int[] nums, int[] memo, int[] from) {
        if (memo[i] > 0) {
            return memo[i];
        }
        int res = 0;
        for (int j = 0; j < i; j++) {
            if (nums[i] % nums[j] != 0) {
                continue;
            }
            int f = dfs(j, nums, memo, from);
            if (f > res) {
                res = f;
                from[i] = j;
            }
        }
        return memo[i] = res + 1;
    }
}
