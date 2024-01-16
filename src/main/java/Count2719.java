import java.util.Arrays;

/**
 * 2719. 统计整数数目
 * hard
 *
 * @author avatarannappa
 * @date 2024/1/16
 */
public class Count2719 {

    private static final int MOD = 1_000_000_007;

    public int count(String num1, String num2, int minSum, int maxSum) {
        // 避免负数
        int ans = calc(num2, minSum, maxSum) - calc(num1, minSum, maxSum) + MOD;
        int sum = 0;
        for (char c : num1.toCharArray()) {
            sum += c - '0';
        }
        if (minSum <= sum && sum <= maxSum) {
            // num1 是合法的，补回来
            ans++;
        }
        return ans % MOD;
    }

    private int calc(String s, int minSum, int maxSum) {
        int n = s.length();
        int[][] memo = new int[n][Math.min(9 * n, maxSum) + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(0, 0, true, s.toCharArray(), minSum, maxSum, memo);
    }

    private int dfs(int i, int sum, boolean isLimit, char[] s, int minSum, int maxSum, int[][] memo) {
        if (sum > maxSum) {
            // 非法
            return 0;
        }
        if (i == s.length) {
            return sum >= minSum ? 1 : 0;
        }
        if (!isLimit && memo[i][sum] != -1) {
            return memo[i][sum];
        }

        int up = isLimit ? s[i] - '0' : 9;
        int res = 0;
        for (int d = 0; d <= up; d++) {
            // 枚举当前数位填 d
            res = (res + dfs(i + 1, sum + d, isLimit && (d == up), s, minSum, maxSum, memo)) % MOD;
        }

        if (!isLimit) {
            memo[i][sum] = res;
        }
        return res;
    }

    public static void main(String[] args) {
        String num1 = "1", num2 = "12";
        int min_num = 1, max_num = 8;
        // 11
        System.out.println(new Count2719().count(num1, num2, min_num, max_num));
    }
}
