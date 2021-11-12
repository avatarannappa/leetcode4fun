/**
 * 629. K个逆序对数组. 
 * hard
 *
 * @author avatarannappa
 * @version 1.0, 2021/11/12
 */
public class KInversePairs629 {
    public int kInversePairs(int n, int k) {
        // DP + 优化, O(n*k*k) -> O(n*k)
        // f[i][j] = f[i][j−1] + f[i−1][j] − f[i−1][j−i] 
        int mod = (int) (1e9 + 7);
        long[][] dp = new long[n + 1][k + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = (j > 0 ? dp[i][j - 1] : 0) + dp[i - 1][j] - (j >= i ? dp[i - 1][j - i] : 0);
                dp[i][j] = (dp[i][j] + mod) % mod;
            }
        }

        return (int) dp[n][k] % mod;
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        // 2
        System.out.println(new KInversePairs629().kInversePairs(n, k));
    }
}
