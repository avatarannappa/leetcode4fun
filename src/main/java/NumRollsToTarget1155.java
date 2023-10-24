/**
 * 1155. 掷骰子等于目标和的方法数
 * medium
 *
 * @author avatarannappa
 * @date 2023/10/24
 */
public class NumRollsToTarget1155 {

    int MOD = 1000_000_007;
    int k;
    int[][] cache;

    public int numRollsToTarget(int n, int k, int target) {
        // 记忆化搜索（递归）
        // TODO DP(递推)
        if (n > target || n * k < target) {
            return 0;
        }
        this.k = k;
        this.cache = new int[n + 1][target + 1];
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[0].length; j++) {
                cache[i][j] = -1;
            }
        }
        return recursion(n, target);
    }

    public int recursion(int n, int target) {
        if (target < 0 || n < 0) {
            return 0;
        }
        if (target == 0) {
            return n == 0 ? 1 : 0;
        }
        if (cache[n][target] != -1) {
            return cache[n][target];
        }
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            ans = (ans + recursion(n - 1, target - i)) % MOD;
        }
        cache[n][target] = ans;
        return ans;
    }

    public static void main(String[] args) {
        int n = 30, k = 30, target = 500;
        // 222616187
        System.out.println(new NumRollsToTarget1155().numRollsToTarget(n, k, target));
    }
}
