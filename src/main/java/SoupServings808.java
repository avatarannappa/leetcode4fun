/**
 * 808. 分汤.
 * medium
 *
 * @author chenhao138
 * @date 2022/11/21
 */
public class SoupServings808 {


    private double[][] dp;

    public double soupServings(int n) {
        // 记忆化搜索  + 期望&精确度5个9的裁剪 + 概率
        n = (int) Math.ceil((double) n / 25);
        if (n >= 179) {
            return 1.0;
        }
        dp = new double[n + 1][n + 1];
        return dfs(n, n);
    }

    public double dfs(int a, int b) {
        if (a <= 0 && b <= 0) {
            return 0.5;
        } else if (a <= 0) {
            return 1;
        } else if (b <= 0) {
            return 0;
        }
        if (dp[a][b] == 0) {
            dp[a][b] = 0.25 * (dfs(a - 4, b) + dfs(a - 3, b - 1) + dfs(a - 2, b - 2) + dfs(a - 1, b - 3));
        }
        return dp[a][b];
    }

    public double soupServingsDP(int n) {
        // DP
        n = (int) Math.ceil((double) n / 25);
        if (n >= 179) {
            return 1.0;
        }
        dp = new double[n + 1][n + 1];
        dp[0][0] = 0.5;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = 1.0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] =
                    0.25 * (dp[Math.max(0, i - 4)][j] + dp[Math.max(0, i - 3)][Math.max(0, j - 1)] + dp[Math.max(0,
                        i - 2)][Math.max(0, j - 2)] + dp[Math.max(0, i - 1)][Math.max(0, j - 3)]);
            }
        }
        return dp[n][n];
    }

    public static void main(String[] args) {
        int n = 100;
        // 0.71875
        System.out.println(new SoupServings808().soupServings(n));
    }
}
