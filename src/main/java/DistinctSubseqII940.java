import java.util.Arrays;

/**
 * 940. 不同的子序列 II
 * hard
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/10/14
 */
public class DistinctSubseqII940 {
    
    private final long MOD = (long) 1e9 + 7;

    public int distinctSubseqII(String s) {
        // DP 一维数组
        int n = s.length();
        long[] dp = new long[26];
        for (int i = 0; i < n; i++) {
            dp[s.charAt(i) - 'a'] = 1 + Arrays.stream(dp).sum() % MOD;
        }
        return (int) (Arrays.stream(dp).sum() % MOD);
    }
    
    public int distinctSubseqIIOld(String s) {
        // DP f(i) = 1 + f(0)...f(i-1)累加 - 累加中末尾字符串等于s[i]的数量
        // 二维dp数组，第一维是字符串index，第二维是以s[i]字符结尾的子串累计数量
        int n = s.length();
        long[][] dp = new long[n][26];
        dp[0][s.charAt(0) - 'a'] = 1;
        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            int m = c - 'a';
            dp[i] = dp[i-1].clone();
            // 第i个字符组成的以s[i]字符结尾的子串 a = 1 + Arrays.stream(dp[i - 1]).sum() - dp[i-1][m]
            // 累计的以s[i]字符结尾的子串 b = a + dp[i-1][m] 及 1 + Arrays.stream(dp[i - 1]).sum() 
            dp[i][m] = (1 + Arrays.stream(dp[i - 1]).sum() - dp[i-1][m] + dp[i-1][m]) % MOD;
        }
        return (int) (Arrays.stream(dp[n-1]).sum() % MOD);
    }

    public static void main(String[] args) {
        String s = "aba";
        // 6
        // a, b, ab, ba, aa, aba
        System.out.println(new DistinctSubseqII940().distinctSubseqII(s));
    }
}
