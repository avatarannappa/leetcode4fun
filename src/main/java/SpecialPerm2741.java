import java.util.Arrays;

/**
 * 2741. 特别的排列
 * medium
 *
 * @author avatarannappa
 * @date 2024/6/26
 */
public class SpecialPerm2741 {

    int mod = 1000000007;
    long[][] dp;
    int mask;

    public int specialPerm(int[] nums) {
        // 回溯 & 记忆化搜索 & 状态压测
        int n = nums.length;
        this.mask = (1 << n) - 1;
        dp = new long[1 << n][n];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += dfs(nums, i, 1 << i);
        }
        return (int) (ans % mod);
    }

    private long dfs(int[] nums, int pre, int now) {
        if (mask == now) {
            return 1;
        }
        if (dp[now][pre] != -1) {
            return dp[now][pre];
        }
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (((now & (1 << i)) >> i) == 1) {
                continue;
            }
            if (nums[pre] % nums[i] == 0 || nums[i] % nums[pre] == 0) {
                now = now | (1 << i);
                res += dfs(nums, i, now) % mod;
                now = now & (~(1 << i));
            }
        }
        dp[now][pre] = res;
        return res;
    }

    public int specialPermOld(int[] nums) {
        // 全排列，超时。时间复杂度O(n!) 14! > 10^9
        int n = nums.length;
        boolean[] visited = new boolean[n];
        return dfsOld(nums, 0, -1, visited);

    }

    private int dfsOld(int[] nums, int depth, int pre, boolean[] visited) {
        if (depth == nums.length) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (pre == -1) {
                visited[i] = true;
                res += dfsOld(nums, depth + 1, i, visited);
                visited[i] = false;
            } else {
                if (nums[pre] % nums[i] == 0 || nums[i] % nums[pre] == 0) {
                    visited[i] = true;
                    res += dfsOld(nums, depth + 1, i, visited);
                    visited[i] = false;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 6};
        // 输出：2
        System.out.println(new SpecialPerm2741().specialPerm(nums));
    }
}
