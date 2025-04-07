import java.util.Arrays;

/**
 * 416. 分割等和子集.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2020/5/18
 */
public class CanPartition416 {


    public boolean canPartition(int[] nums) {
        // 记忆化搜搜
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }

        int n = nums.length;
        sum /= 2;
        int[][] memo = new int[n][sum + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(n - 1, sum, nums, memo);
    }

    private boolean dfs(int i, int sum, int[] nums, int[][] memo) {
        if (i < 0) {
            return sum == 0;
        }
        if (memo[i][sum] != -1) {
            return memo[i][sum] == 1;
        }
        boolean res = (sum >= nums[i] && dfs(i - 1, sum - nums[i], nums, memo)) || dfs(i - 1, sum, nums, memo);
        memo[i][sum] = res ? 1 : 0;
        return res;
    }

    private int[] nums;

    public boolean canPartitionOld(int[] nums) {
        // 超时
        if (nums == null || nums.length < 2) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        sum >>= 1;
        this.nums = nums;
        return recursion(nums.length - 1, sum, sum);
    }

    public boolean recursion(int index, int a, int b) {
        if (a == 0 || b == 0) {
            return true;
        } else if (a < 0 || b < 0) {
            return false;
        } else {
            return recursion(index - 1, a - nums[index], b) || recursion(index - 1, a, b - nums[index]);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println(new CanPartition416().canPartition(nums));
    }
}
